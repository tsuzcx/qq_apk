import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.FavoriteCKVData.KandianFavoriteBizData;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteReqBody;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.ReqBody;

public class lgv
{
  public static final String TAG = "Q.readinjoy.atlas.." + lgv.class.getSimpleName();
  public static lgv a;
  static HashMap<Integer, String> dJ = new HashMap();
  private lhj a;
  
  static
  {
    dJ.put(Integer.valueOf(1), "");
    dJ.put(Integer.valueOf(2), "");
    dJ.put(Integer.valueOf(3), "");
  }
  
  public lgv()
  {
    this.jdField_a_of_type_Lhj = new lhj();
  }
  
  public static lgv a()
  {
    if (jdField_a_of_type_Lgv == null) {}
    try
    {
      if (jdField_a_of_type_Lgv == null) {
        jdField_a_of_type_Lgv = new lgv();
      }
      return jdField_a_of_type_Lgv;
    }
    finally {}
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ArrayList<byte[]> paramArrayList)
  {
    new aviz(6).a("nLinkType", 0).b("sTitle", paramString2).b("sUrl", paramString6).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", paramString4).b("sBrief", paramString3).b("sPath", paramString5).b("sResUrl", paramString6).a("lCategory", 8L).b("sBizDataList", paramArrayList).b(paramActivity, paramString1, -1, null);
  }
  
  public static boolean h(Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    if (kxm.a(BaseApplicationImpl.getApplication().getRuntime(), "Key_First_ReadInJoy_Favorite", true) == null)
    {
      kxm.b("Key_First_ReadInJoy_Favorite", Integer.valueOf(1), true);
      if (!paramBoolean) {
        aqha.a(paramContext, 230, paramContext.getString(2131693449), "你可在看点内点击“我的”找到“我的收藏”。\n收藏的内容将会上传保存，在其他手机上登录QQ，也可以在看点内找到你收藏的内容。\n", 2131721058, 2131693447, new lgx(), null).setMessageCount(null).show();
      }
      bool = true;
    }
    return bool;
  }
  
  public void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    FavoriteCKVData.KandianFavoriteBizData localKandianFavoriteBizData = new FavoriteCKVData.KandianFavoriteBizData();
    localKandianFavoriteBizData.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramString2));
    localKandianFavoriteBizData.uint32_type.set(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (paramBundle != null)
    {
      paramInt = paramBundle.getInt("videoDuration");
      localKandianFavoriteBizData.uint32_video_duration.set(paramInt);
      paramInt = paramBundle.getInt("picNum");
      localKandianFavoriteBizData.uint32_pic_num.set(paramInt);
      long l = paramBundle.getLong("publishAccountUin");
      localKandianFavoriteBizData.uint64_account_id.set(l);
      paramString2 = paramBundle.getString("publishAccountName");
      if (!TextUtils.isEmpty(paramString2))
      {
        localKandianFavoriteBizData.bytes_account_name.set(ByteStringMicro.copyFromUtf8(paramString2));
        l = paramBundle.getLong("feedsId");
        localKandianFavoriteBizData.uint64_feeds_id.set(l);
        paramInt = paramBundle.getInt("feedsType");
        localKandianFavoriteBizData.uint32_feeds_type.set(paramInt);
        paramInt = paramBundle.getInt("videoType");
        localKandianFavoriteBizData.uint32_video_type.set(paramInt);
      }
    }
    for (;;)
    {
      localArrayList.add(localKandianFavoriteBizData.toByteArray());
      a(paramActivity, paramString1, paramString3, paramString4, paramString2, paramString5, paramString6, localArrayList);
      return;
      paramString2 = "";
      break;
      paramString2 = "";
    }
  }
  
  public void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, ArrayList<String> paramArrayList)
  {
    FavoriteCKVData.KandianFavoriteBizData localKandianFavoriteBizData = new FavoriteCKVData.KandianFavoriteBizData();
    localKandianFavoriteBizData.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramString2));
    localKandianFavoriteBizData.uint32_type.set(paramInt);
    paramString2 = new ArrayList();
    paramString2.add(localKandianFavoriteBizData.toByteArray());
    new aviz(6).a("sCIDListToBeDelete", paramArrayList).b("sBizDataList", paramString2).a(paramActivity, paramString1, -1, null);
  }
  
  public void a(List<String> paramList, lgv.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getAtlasFavoriteStatus, rowKeyList = " + paramList + ", callback = " + parama);
    }
    oidb_0xb40.ReqBody localReqBody = new oidb_0xb40.ReqBody();
    oidb_0xb40.CheckFavoriteReqBody localCheckFavoriteReqBody = new oidb_0xb40.CheckFavoriteReqBody();
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!TextUtils.isEmpty(str)) {
        localCheckFavoriteReqBody.rpt_bytes_rowkey.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    localReqBody.msg_check_favorite_req.set(localCheckFavoriteReqBody);
    paramList = new Bundle();
    jnm.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new lgw(this, parama), localReqBody.toByteArray(), "OidbSvc.0xb40", 2880, 1, paramList, 0L);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2);
    
    public abstract void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList);
  }
  
  public static abstract class b
    implements lgv.a
  {
    public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
    
    public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgv
 * JD-Core Version:    0.7.0.1
 */