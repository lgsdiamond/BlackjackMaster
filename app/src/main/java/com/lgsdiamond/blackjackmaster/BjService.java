package com.lgsdiamond.blackjackmaster;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.lgsdiamond.blackjackmaster.blackjackelement.Dealer;
import com.lgsdiamond.blackjackmaster.blackjackelement.DealerHand;
import com.lgsdiamond.blackjackmaster.blackjackelement.Hand;
import com.lgsdiamond.blackjackmaster.blackjackelement.PlayerHand;
import com.lgsdiamond.blackjackmaster.blackjackelement.Rule;
import com.lgsdiamond.blackjackmaster.blackjackelement.Strategy;

import java.util.Random;

/**
 * Created by LgsDi on 2018-03-04.
 */

public class BjService extends IntentService {
    // define service intent strings
    public static final String SERVICE_READY = "SERVICE_READY";
    private boolean mIsBound = false;
    private LocalBinder mBinder = new LocalBinder();


    public BjService() {
        super("BjService");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mIsBound = true;
        return mBinder;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    class LocalBinder extends Binder {
        BjService getService() {
            return BjService.this;
        }
    }

    //=== testing
    private final Random rand = new Random();

    public int getRandomNumber() {
        return rand.nextInt(1000);
    }

    //*********
    //==== JUST FOR COMPILING ===
    public Rule pGameRule;
    private Hand mHandFocused = null, mHandFocused_prev = null;
    public Dealer pDealer;


    public enum RoundResult {UNKNOWN, WIN, PUSH, LOST}

    public static boolean isAutoRunning() {       // TODO - just quick & dirty
        return false;
    }

    public PlayerHand.Action getBestPlayAction() {
        Hand hand = getHandFocused();
        if (hand instanceof DealerHand) return PlayerHand.Action.STAND; //?? never happen

        Strategy strategy = ((PlayerHand) hand).getBox().getStrategy();

        return (strategy.getBestAction(((PlayerHand) hand), getDealerHand().getUpScore()));
    }

    public Hand getHandFocused() {
        return mHandFocused;
    }

    public DealerHand getDealerHand() {
        return pDealer.getHand();
    }

    //==== JUST FOR COMPILING ===

}