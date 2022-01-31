import NS_KING_SOCIALIZE_META.stShareBody;
import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil.1;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public class tlr
{
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2, String paramString)
  {
    if (tlv.b()) {
      return;
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = paramContext;
    localObject = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    ((ShareActionSheet)localObject).setActionSheetTitle(paramContext.getString(2131693003));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
    localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
    ((ShareActionSheet)localObject).setItemClickListenerV2(new tlt(paramContext, paramstSimpleMetaFeed, paramInt1, paramInt2, paramString));
    ((ShareActionSheet)localObject).setActionSheetItems(localArrayList1, localArrayList2);
    ((ShareActionSheet)localObject).setRowVisibility(0, 0, 0);
    paramContext = (Activity)paramContext;
    if (paramContext != null)
    {
      paramContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
      ((ShareActionSheet)localObject).setIntentForStartForwardRecentActivity(paramContext.getIntent());
    }
    ((ShareActionSheet)localObject).show();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramContext == null) {
      return;
    }
    paramString2 = (Activity)paramContext;
    paramContext = paramString2;
    if ((paramString2 instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)paramString2).getOutActivity();
    }
    paramString2 = new Intent(paramContext, ForwardRecentActivity.class);
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2.putExtra("forward_type", 2);
      paramString2.putExtra("req_type", 1);
      paramString2.putExtra("req_share_id", Long.parseLong("1101083114"));
      paramString2.putExtra("title", paramString1);
      paramString2.putExtra("app_name", alpo.a(2131717300));
      paramString2.putExtra("image_url_remote", paramString3);
      paramString2.putExtra("desc", alpo.a(2131717299));
      paramString2.putExtra("detail_url", paramString4);
    }
    paramContext.startActivity(paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (paramContext == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (Activity)paramContext;
      paramContext = (Context)localObject;
      if ((localObject instanceof BasePluginActivity)) {
        paramContext = ((BasePluginActivity)localObject).getOutActivity();
      }
      localObject = new Intent();
    } while (TextUtils.isEmpty(paramString3));
    ((Intent)localObject).putExtra("forward_type", 2);
    ((Intent)localObject).putExtra("req_type", 1);
    ((Intent)localObject).putExtra("req_share_id", Long.parseLong("1101083114"));
    ((Intent)localObject).putExtra("title", paramString1);
    ((Intent)localObject).putExtra("app_name", alpo.a(2131717300));
    ((Intent)localObject).putExtra("image_url_remote", paramString2);
    ((Intent)localObject).putExtra("desc", alpo.a(2131717299));
    ((Intent)localObject).putExtra("detail_url", paramString3);
    ((Intent)localObject).putExtra("key_req", ForwardRecentActivity.f);
    ((Intent)localObject).putExtra("key_direct_show_uin_type", paramInt);
    ((Intent)localObject).putExtra("key_direct_show_uin", paramString4);
    arum.a(paramContext, (Intent)localObject, ForwardRecentTranslucentActivity.class, 1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = (Activity)paramContext;
    paramContext = (Context)localObject;
    if ((localObject instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)localObject).getOutActivity();
    }
    localObject = new QZoneShareData();
    ((QZoneShareData)localObject).jdField_b_of_type_JavaLangString = paramString1;
    ((QZoneShareData)localObject).c = paramString2;
    ((QZoneShareData)localObject).a = new ArrayList();
    ((QZoneShareData)localObject).a.add(paramString3);
    ((QZoneShareData)localObject).jdField_b_of_type_Int = 0;
    ((QZoneShareData)localObject).d = paramString4;
    ((QZoneShareData)localObject).f = paramString5;
    bjao.a(paramContext, paramString5, (QZoneShareData)localObject, null, paramInt);
  }
  
  private static void b(Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2, String paramString)
  {
    int i = paramActionSheetItem.action;
    int j = paramActionSheetItem.uinType;
    String str2 = paramActionSheetItem.uin;
    if ((paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.share_info == null)) {}
    label29:
    String str1;
    Object localObject1;
    do
    {
      Object localObject6;
      do
      {
        Object localObject5;
        do
        {
          Object localObject4;
          do
          {
            Object localObject3;
            do
            {
              return;
              str1 = paramstSimpleMetaFeed.share_info.jump_url;
              Object localObject2 = null;
              localObject3 = null;
              localObject4 = null;
              localObject5 = null;
              localObject6 = null;
              localObject1 = null;
              if (TextUtils.equals(paramString, "focus")) {}
              for (paramActionSheetItem = "dynamics_more_operations" + paramInt2;; paramActionSheetItem = "more_operations") {
                switch (i)
                {
                default: 
                  return;
                case 2: 
                  if (paramstSimpleMetaFeed.share_info.body_map != null) {
                    localObject1 = (stShareBody)paramstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(1));
                  }
                  if (localObject1 == null) {
                    break label29;
                  }
                  WSPublicAccReport.getInstance().reportShareClick(paramActionSheetItem, 1003019, paramString, paramstSimpleMetaFeed);
                  a(paramContext, ((stShareBody)localObject1).title, ((stShareBody)localObject1).desc, ((stShareBody)localObject1).image_url, str1);
                  return;
                }
              }
              localObject1 = localObject2;
              if (paramstSimpleMetaFeed.share_info.body_map != null) {
                localObject1 = (stShareBody)paramstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(1));
              }
            } while (localObject1 == null);
            WSPublicAccReport.getInstance().reportShareClick(paramActionSheetItem, 1003020, paramString, paramstSimpleMetaFeed);
            a(paramContext, ((stShareBody)localObject1).title, ((stShareBody)localObject1).desc, ((stShareBody)localObject1).image_url, str1);
            return;
            localObject1 = localObject3;
            if (paramstSimpleMetaFeed.share_info.body_map != null) {
              localObject1 = (stShareBody)paramstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(1));
            }
          } while (localObject1 == null);
          WSPublicAccReport.getInstance().reportShareClick(paramActionSheetItem, 1003002, paramString, paramstSimpleMetaFeed);
          a(paramContext, ((stShareBody)localObject1).title, ((stShareBody)localObject1).image_url, str1, str2, j);
          return;
          localObject1 = localObject4;
          if (paramstSimpleMetaFeed.share_info.body_map != null) {
            localObject1 = (stShareBody)paramstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(0));
          }
        } while (localObject1 == null);
        try
        {
          WSPublicAccReport.getInstance().reportShareClick(paramActionSheetItem, 1003003, paramString, paramstSimpleMetaFeed);
          a(paramContext, ((stShareBody)localObject1).title, ((stShareBody)localObject1).desc, ((stShareBody)localObject1).image_url, str1, str2, 0);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          tlo.d("WeishiShareUtil", "shareToQzone error:" + paramContext);
          return;
        }
        localObject1 = localObject5;
        if (paramstSimpleMetaFeed.share_info.body_map != null) {
          localObject1 = (stShareBody)paramstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(3));
        }
      } while (localObject1 == null);
      WSPublicAccReport.getInstance().reportShareClick(paramActionSheetItem, 1003004, paramString, paramstSimpleMetaFeed);
      b(paramContext, ((stShareBody)localObject1).title, ((stShareBody)localObject1).desc, ((stShareBody)localObject1).image_url, str1, 0);
      return;
      localObject1 = localObject6;
      if (paramstSimpleMetaFeed.share_info.body_map != null) {
        localObject1 = (stShareBody)paramstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(3));
      }
    } while (localObject1 == null);
    WSPublicAccReport.getInstance().reportShareClick(paramActionSheetItem, 1003005, paramString, paramstSimpleMetaFeed);
    b(paramContext, ((stShareBody)localObject1).title, ((stShareBody)localObject1).desc, ((stShareBody)localObject1).image_url, str1, 1);
    return;
    WSPublicAccReport.getInstance().reportShareClick(paramActionSheetItem, 1003012, paramString, paramstSimpleMetaFeed);
    bfhq.a().a("已收到您的举报，我们会及时处理");
    paramContext = tjr.a(paramstSimpleMetaFeed, paramInt2);
    paramContext.jubao_reason = "用户手动点击举报";
    tjr.a(116, paramInt1, paramContext);
    return;
    WSPublicAccReport.getInstance().reportShareClick(paramActionSheetItem, 1003008, paramString, paramstSimpleMetaFeed);
    bfhq.a().a("后面会减少此类推荐");
    paramContext = tjr.a(paramstSimpleMetaFeed, paramInt2);
    paramContext.dislike_reason = "用户手动点击不感兴趣";
    tjr.a(8, paramInt1, paramContext);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (!WXShareHelper.a().a()) {
      bfhq.a().a(2131721478);
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      ThreadManager.getSubThreadHandler().post(new WeishiShareUtil.1(paramString3, String.valueOf(l), paramString1, paramString2, paramString4, paramInt));
      WXShareHelper.a().a(new tls());
      return;
      if (!WXShareHelper.a().b()) {
        bfhq.a().a(2131721479);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tlr
 * JD-Core Version:    0.7.0.1
 */