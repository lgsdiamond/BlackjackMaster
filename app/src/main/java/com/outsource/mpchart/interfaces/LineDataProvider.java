package com.outsource.mpchart.interfaces;

import com.outsource.mpchart.components.YAxis;
import com.outsource.mpchart.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
