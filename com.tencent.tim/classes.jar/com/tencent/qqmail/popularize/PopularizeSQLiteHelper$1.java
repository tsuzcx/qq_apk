package com.tencent.qqmail.popularize;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeAppConfig;
import java.util.ArrayList;

class PopularizeSQLiteHelper$1
  implements Runnable
{
  PopularizeSQLiteHelper$1(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, Popularize paramPopularize, SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    int i7 = 1;
    int i8 = this.val$popularize.getId();
    int i9 = this.val$popularize.getServerId();
    int i10 = this.val$popularize.getReportId();
    int i11 = this.val$popularize.getType();
    int i12 = this.val$popularize.getPage();
    int i13 = this.val$popularize.getBannerPosition();
    double d1 = this.val$popularize.getBannerHeight();
    int i14 = this.val$popularize.getShowType();
    int i15 = this.val$popularize.getAction();
    Object localObject = this.val$popularize.getImageUrl();
    String str1 = this.val$popularize.getImageMd5();
    String str2 = this.val$popularize.getOpenUrl();
    double d2 = this.val$popularize.getStartTime();
    double d3 = this.val$popularize.getEndTime();
    double d4 = this.val$popularize.getDuration();
    String str3 = this.val$popularize.getSubject();
    String str4 = this.val$popularize.getAbstracts();
    String str5 = this.val$popularize.getContent();
    String str6 = this.val$popularize.getSubInformation();
    String str7 = this.val$popularize.getSubInformationData();
    String str8 = this.val$popularize.getSubImageUrl();
    String str9 = this.val$popularize.getSubImageMd5();
    int i;
    int j;
    label225:
    int k;
    label238:
    int m;
    label251:
    String str10;
    int i16;
    int i17;
    long l;
    int i18;
    int i19;
    int i20;
    int i21;
    boolean bool;
    String str11;
    int i22;
    String str12;
    String str13;
    int n;
    label384:
    int i1;
    label397:
    int i2;
    label410:
    int i3;
    label423:
    int i4;
    label436:
    int i23;
    int i5;
    label458:
    String str14;
    String str15;
    String str16;
    String str17;
    String str18;
    String str19;
    int i6;
    if (this.val$popularize.isNeedQQAccount())
    {
      i = 1;
      if (!this.val$popularize.isRender()) {
        break label1084;
      }
      j = 1;
      if (!this.val$popularize.isClick()) {
        break label1090;
      }
      k = 1;
      if (!this.val$popularize.isCancel()) {
        break label1096;
      }
      m = 1;
      str10 = this.val$popularize.getPopularizeAppName();
      i16 = this.val$popularize.getAppInstallAction();
      i17 = this.val$popularize.getWeight();
      l = this.val$popularize.getLastRenderTime();
      i18 = this.val$popularize.getCondition();
      i19 = this.val$popularize.getRelatedId();
      i20 = this.val$popularize.getMove();
      i21 = this.val$popularize.getAppConfig().getPriority();
      bool = this.val$popularize.isOpen();
      str11 = this.val$popularize.getPopularizeAppVersion();
      i22 = this.val$popularize.getResourceType();
      str12 = this.val$popularize.getCommercialFromEmail();
      str13 = this.val$popularize.getCommercialFromNick();
      if (!this.val$popularize.isCommercialConfigHead()) {
        break label1102;
      }
      n = 1;
      if (!this.val$popularize.isCommercialConfigTool()) {
        break label1108;
      }
      i1 = 1;
      if (!this.val$popularize.isCommercialConfigList()) {
        break label1114;
      }
      i2 = 1;
      if (!this.val$popularize.isCommercialConfigMark()) {
        break label1120;
      }
      i3 = 1;
      if (!this.val$popularize.isRead()) {
        break label1126;
      }
      i4 = 1;
      i23 = this.val$popularize.getSessionType();
      if (!this.val$popularize.isNeedWifi()) {
        break label1132;
      }
      i5 = 1;
      str14 = this.val$popularize.getAdXml();
      str15 = this.val$popularize.getSub_fromnick();
      str16 = this.val$popularize.getSub_subject();
      str17 = this.val$popularize.getSub_abstracts();
      str18 = this.val$popularize.getAvatar_url();
      str19 = this.val$popularize.getAvatar_url_md5();
      if (!this.val$popularize.isStop()) {
        break label1138;
      }
      i6 = 1;
      label525:
      if (!this.val$popularize.isPopByNewMail()) {
        break label1144;
      }
    }
    for (;;)
    {
      int i24 = this.val$popularize.getProductId();
      int i25 = this.val$popularize.getTurnId();
      this.val$writableDb.execSQL("REPLACE INTO QM_POPULARIZE (id , serverId , reportId , type , page , bannerPosition , bannerHeight , showType , action , imageUrl , imageMd5 , openUrl , startTime , endTime , duration , subject , abstracts , content , subInformation , subInformationData , subImageUrl , subImageMd5 , needQQAccount , isRender , isClick , isCancel , popularizeAppName , appInstallAction , weight , lastRenderTime , condition , relatedId , move , priority , isOpen , popularizeAppVersion , resourceType , commercialFromEmail , commercialFromNick , commercialConfigHead , commercialConfigTool , commercialConfigList , commercialConfigMark , isRead , sessionType , needWifi , adXml , sub_fromnick , sub_subject , sub_abstracts , avatar_url , avatar_url_md5 , isStop , isPop , product_id , turn_id  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Double.valueOf(d1), Integer.valueOf(i14), Integer.valueOf(i15), localObject, str1, str2, Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), str3, str4, str5, str6, str7, str8, str9, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str10, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(l), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i20), Integer.valueOf(i21), Boolean.valueOf(bool), str11, Integer.valueOf(i22), str12, str13, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i23), Integer.valueOf(i5), str14, str15, str16, str17, str18, str19, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i24), Integer.valueOf(i25) });
      localObject = new ArrayList();
      ((ArrayList)localObject).addAll(this.val$popularize.getSubItems());
      if ((this.val$popularize.getAppConfig() != null) && (this.val$popularize.getAppConfig().getSubitems() != null)) {
        ((ArrayList)localObject).addAll(this.val$popularize.getAppConfig().getSubitems());
      }
      this.this$0.insertPopularizeSubItem(this.val$writableDb, (ArrayList)localObject);
      return;
      i = 0;
      break;
      label1084:
      j = 0;
      break label225;
      label1090:
      k = 0;
      break label238;
      label1096:
      m = 0;
      break label251;
      label1102:
      n = 0;
      break label384;
      label1108:
      i1 = 0;
      break label397;
      label1114:
      i2 = 0;
      break label410;
      label1120:
      i3 = 0;
      break label423;
      label1126:
      i4 = 0;
      break label436;
      label1132:
      i5 = 0;
      break label458;
      label1138:
      i6 = 0;
      break label525;
      label1144:
      i7 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.1
 * JD-Core Version:    0.7.0.1
 */