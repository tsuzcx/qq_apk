package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stWMDBCombinRsp
  extends JceStruct
{
  static ArrayList<stAD> cache_ads;
  static stAndroidPush cache_androidPush;
  static ArrayList<stCategory> cache_categories;
  static stVersions cache_curVersions;
  static stFlashScreen cache_flashScreen;
  static ArrayList<stOpDataItem> cache_opData;
  static stReturns cache_retures;
  static ArrayList<stWatermark> cache_watermarks;
  static ArrayList<stWatermark> cache_watermarksAdv;
  static ArrayList<stWatermark> cache_watermarksInt;
  static ArrayList<stWMResource> cache_wmResources;
  public ArrayList<stAD> ads = null;
  public stAndroidPush androidPush = null;
  public ArrayList<stCategory> categories = null;
  public stVersions curVersions = null;
  public stFlashScreen flashScreen = null;
  public ArrayList<stOpDataItem> opData = null;
  public stReturns retures = null;
  public ArrayList<stWatermark> watermarks = null;
  public ArrayList<stWatermark> watermarksAdv = null;
  public ArrayList<stWatermark> watermarksInt = null;
  public ArrayList<stWMResource> wmResources = null;
  
  public stWMDBCombinRsp() {}
  
  public stWMDBCombinRsp(stVersions paramstVersions, stReturns paramstReturns, ArrayList<stWatermark> paramArrayList1, ArrayList<stCategory> paramArrayList, ArrayList<stWMResource> paramArrayList2, stFlashScreen paramstFlashScreen, stAndroidPush paramstAndroidPush, ArrayList<stAD> paramArrayList3, ArrayList<stOpDataItem> paramArrayList4, ArrayList<stWatermark> paramArrayList5, ArrayList<stWatermark> paramArrayList6)
  {
    this.curVersions = paramstVersions;
    this.retures = paramstReturns;
    this.watermarks = paramArrayList1;
    this.categories = paramArrayList;
    this.wmResources = paramArrayList2;
    this.flashScreen = paramstFlashScreen;
    this.androidPush = paramstAndroidPush;
    this.ads = paramArrayList3;
    this.opData = paramArrayList4;
    this.watermarksInt = paramArrayList5;
    this.watermarksAdv = paramArrayList6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_curVersions == null) {
      cache_curVersions = new stVersions();
    }
    this.curVersions = ((stVersions)paramJceInputStream.read(cache_curVersions, 0, true));
    if (cache_retures == null) {
      cache_retures = new stReturns();
    }
    this.retures = ((stReturns)paramJceInputStream.read(cache_retures, 1, true));
    Object localObject;
    if (cache_watermarks == null)
    {
      cache_watermarks = new ArrayList();
      localObject = new stWatermark();
      cache_watermarks.add(localObject);
    }
    this.watermarks = ((ArrayList)paramJceInputStream.read(cache_watermarks, 2, true));
    if (cache_categories == null)
    {
      cache_categories = new ArrayList();
      localObject = new stCategory();
      cache_categories.add(localObject);
    }
    this.categories = ((ArrayList)paramJceInputStream.read(cache_categories, 3, true));
    if (cache_wmResources == null)
    {
      cache_wmResources = new ArrayList();
      localObject = new stWMResource();
      cache_wmResources.add(localObject);
    }
    this.wmResources = ((ArrayList)paramJceInputStream.read(cache_wmResources, 4, true));
    if (cache_flashScreen == null) {
      cache_flashScreen = new stFlashScreen();
    }
    this.flashScreen = ((stFlashScreen)paramJceInputStream.read(cache_flashScreen, 5, true));
    if (cache_androidPush == null) {
      cache_androidPush = new stAndroidPush();
    }
    this.androidPush = ((stAndroidPush)paramJceInputStream.read(cache_androidPush, 6, true));
    if (cache_ads == null)
    {
      cache_ads = new ArrayList();
      localObject = new stAD();
      cache_ads.add(localObject);
    }
    this.ads = ((ArrayList)paramJceInputStream.read(cache_ads, 7, true));
    if (cache_opData == null)
    {
      cache_opData = new ArrayList();
      localObject = new stOpDataItem();
      cache_opData.add(localObject);
    }
    this.opData = ((ArrayList)paramJceInputStream.read(cache_opData, 8, true));
    if (cache_watermarksInt == null)
    {
      cache_watermarksInt = new ArrayList();
      localObject = new stWatermark();
      cache_watermarksInt.add(localObject);
    }
    this.watermarksInt = ((ArrayList)paramJceInputStream.read(cache_watermarksInt, 9, false));
    if (cache_watermarksAdv == null)
    {
      cache_watermarksAdv = new ArrayList();
      localObject = new stWatermark();
      cache_watermarksAdv.add(localObject);
    }
    this.watermarksAdv = ((ArrayList)paramJceInputStream.read(cache_watermarksAdv, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.curVersions, 0);
    paramJceOutputStream.write(this.retures, 1);
    paramJceOutputStream.write(this.watermarks, 2);
    paramJceOutputStream.write(this.categories, 3);
    paramJceOutputStream.write(this.wmResources, 4);
    paramJceOutputStream.write(this.flashScreen, 5);
    paramJceOutputStream.write(this.androidPush, 6);
    paramJceOutputStream.write(this.ads, 7);
    paramJceOutputStream.write(this.opData, 8);
    if (this.watermarksInt != null) {
      paramJceOutputStream.write(this.watermarksInt, 9);
    }
    if (this.watermarksAdv != null) {
      paramJceOutputStream.write(this.watermarksAdv, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     WMDBClientInterface.stWMDBCombinRsp
 * JD-Core Version:    0.7.0.1
 */