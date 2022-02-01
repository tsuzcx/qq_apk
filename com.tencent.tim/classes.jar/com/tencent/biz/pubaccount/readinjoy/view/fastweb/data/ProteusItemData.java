package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.pts.core.itemview.PTSItemData;
import org.json.JSONObject;

public class ProteusItemData
  extends BaseData
{
  public JSONObject aD;
  public String amd;
  public String ame;
  public boolean ats = true;
  public int bad = 0;
  public int mModuleType = -1;
  public TemplateBean mTemplateBean;
  public PTSItemData ptsItemData;
  public String ptsLitePageName;
  
  public ProteusItemData(int paramInt)
  {
    super(paramInt);
  }
  
  public ProteusItemData(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void oh(String paramString)
  {
    this.amd = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData
 * JD-Core Version:    0.7.0.1
 */