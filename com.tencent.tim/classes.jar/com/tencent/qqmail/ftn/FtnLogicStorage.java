package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.model.FtnComposeInfo;
import java.util.ArrayList;

public class FtnLogicStorage
{
  private static ArrayList<FtnComposeInfo> mComposeInfos = new ArrayList();
  
  public static ArrayList<FtnComposeInfo> fetchOutComposeInfos()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(mComposeInfos);
    mComposeInfos.clear();
    return localArrayList;
  }
  
  public static ArrayList<FtnComposeInfo> getComposeInfos()
  {
    return mComposeInfos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnLogicStorage
 * JD-Core Version:    0.7.0.1
 */