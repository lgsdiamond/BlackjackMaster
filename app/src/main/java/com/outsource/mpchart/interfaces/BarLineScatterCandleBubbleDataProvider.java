package com.outsource.mpchart.interfaces;

import com.outsource.mpchart.components.YAxis.AxisDependency;
import com.outsource.mpchart.data.BarLineScatterCandleBubbleData;
import com.outsource.mpchart.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);
    int getMaxVisibleCount();
    boolean isInverted(AxisDependency axis);
    
    int getLowestVisibleXIndex();
    int getHighestVisibleXIndex();

    BarLineScatterCandleBubbleData getData();
}
