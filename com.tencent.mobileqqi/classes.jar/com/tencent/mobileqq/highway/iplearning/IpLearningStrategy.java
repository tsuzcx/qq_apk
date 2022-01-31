package com.tencent.mobileqq.highway.iplearning;

import com.tencent.mobileqq.highway.utils.EndPoint;
import java.util.ArrayList;

public abstract interface IpLearningStrategy
{
  public abstract ArrayList<EndPoint> adjustNewIpList(ArrayList<EndPoint> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.iplearning.IpLearningStrategy
 * JD-Core Version:    0.7.0.1
 */