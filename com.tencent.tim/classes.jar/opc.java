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

public class opc
{
  private static void a(int paramInt, ooe paramooe)
  {
    if (paramooe == null) {
      return;
    }
    WSPublicAccReport.getInstance().reportShareClick(paramooe.aqU, paramInt, paramooe.mSopName, paramooe.aqb, paramooe.b);
  }
  
  private static void a(Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ooe paramooe)
  {
    int i = paramActionSheetItem.action;
    int j = paramActionSheetItem.uinType;
    String str2 = paramActionSheetItem.uin;
    if (paramooe == null) {}
    stSimpleMetaFeed localstSimpleMetaFeed;
    String str1;
    int k;
    int m;
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
            Object localObject2;
            do
            {
              Object localObject1;
              do
              {
                do
                {
                  return;
                  localstSimpleMetaFeed = paramooe.b;
                } while ((localstSimpleMetaFeed == null) || (localstSimpleMetaFeed.share_info == null));
                str1 = localstSimpleMetaFeed.share_info.jump_url;
                k = paramooe.mPosition;
                m = paramooe.mPageType;
                localObject1 = null;
                localObject2 = null;
                localObject3 = null;
                localObject4 = null;
                localObject5 = null;
                paramActionSheetItem = null;
                switch (i)
                {
                default: 
                  return;
                case 2: 
                  if (localstSimpleMetaFeed.share_info.body_map != null) {
                    paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(1));
                  }
                  break;
                }
              } while (paramActionSheetItem == null);
              a(1003019, paramooe);
              shareToQQ(paramContext, paramActionSheetItem.title, paramActionSheetItem.desc, paramActionSheetItem.image_url, str1);
              return;
              paramActionSheetItem = localObject1;
              if (localstSimpleMetaFeed.share_info.body_map != null) {
                paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(1));
              }
            } while (paramActionSheetItem == null);
            a(1003020, paramooe);
            shareToQQ(paramContext, paramActionSheetItem.title, paramActionSheetItem.desc, paramActionSheetItem.image_url, str1);
            return;
            paramActionSheetItem = localObject2;
            if (localstSimpleMetaFeed.share_info.body_map != null) {
              paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(1));
            }
          } while (paramActionSheetItem == null);
          a(1003002, paramooe);
          a(paramContext, paramActionSheetItem.title, paramActionSheetItem.image_url, str1, str2, j);
          return;
          paramActionSheetItem = localObject3;
          if (localstSimpleMetaFeed.share_info.body_map != null) {
            paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(0));
          }
        } while (paramActionSheetItem == null);
        try
        {
          a(1003003, paramooe);
          shareToQzone(paramContext, paramActionSheetItem.title, paramActionSheetItem.desc, paramActionSheetItem.image_url, str1, str2, 0);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          ooz.e("WeishiShareUtil", "shareToQzone error:" + paramContext);
          return;
        }
        paramActionSheetItem = localObject4;
        if (localstSimpleMetaFeed.share_info.body_map != null) {
          paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(3));
        }
      } while (paramActionSheetItem == null);
      a(1003004, paramooe);
      b(paramContext, paramActionSheetItem.title, paramActionSheetItem.desc, paramActionSheetItem.image_url, str1, 0);
      return;
      paramActionSheetItem = localObject5;
      if (localstSimpleMetaFeed.share_info.body_map != null) {
        paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(3));
      }
    } while (paramActionSheetItem == null);
    a(1003005, paramooe);
    b(paramContext, paramActionSheetItem.title, paramActionSheetItem.desc, paramActionSheetItem.image_url, str1, 1);
    return;
    a(1003012, paramooe);
    arxa.a().showToast("已收到您的举报，我们会及时处理");
    paramContext = ond.a(localstSimpleMetaFeed, k);
    paramContext.jubao_reason = "用户手动点击举报";
    ond.a(116, m, paramContext);
    return;
    a(1003008, paramooe);
    arxa.a().showToast("后面会减少此类推荐");
    paramContext = ond.a(localstSimpleMetaFeed, k);
    paramContext.dislike_reason = "用户手动点击不感兴趣";
    ond.a(8, m, paramContext);
    return;
    oqs.a(paramContext, 131072, localstSimpleMetaFeed, k);
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
    ((Intent)localObject).putExtra("image_url_remote", paramString2);
    ((Intent)localObject).putExtra("detail_url", paramString3);
    ((Intent)localObject).putExtra("key_req", ForwardRecentActivity.bGS);
    ((Intent)localObject).putExtra("key_direct_show_uin_type", paramInt);
    ((Intent)localObject).putExtra("key_direct_show_uin", paramString4);
    ahgq.a(paramContext, (Intent)localObject, ForwardRecentTranslucentActivity.class, 1);
  }
  
  public static void a(Context paramContext, ooe paramooe)
  {
    if (opn.qH()) {
      return;
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = paramContext;
    localObject = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if ((paramooe != null) && (paramooe.b != null) && (paramooe.b.gdt_ad_type == 1) && (paramooe.b.gdt_ad_info != null))
    {
      ((ShareActionSheet)localObject).setActionSheetTitle("");
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(90));
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(89));
      ((ShareActionSheet)localObject).setActionSheetItems(localArrayList1, localArrayList2);
      ((ShareActionSheet)localObject).setRowVisibility(8, 8, 0);
    }
    for (;;)
    {
      ((ShareActionSheet)localObject).setItemClickListenerV2(new opf(paramContext, paramooe));
      paramContext = (Activity)paramContext;
      if (paramContext != null)
      {
        paramContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
        ((ShareActionSheet)localObject).setIntentForStartForwardRecentActivity(paramContext.getIntent());
      }
      ((ShareActionSheet)localObject).setOnShowListener(new opg(paramooe));
      ((ShareActionSheet)localObject).setCancelListener(new oph(paramooe));
      ((ShareActionSheet)localObject).setOnDismissListener(new opi(paramooe));
      ((ShareActionSheet)localObject).show();
      return;
      ((ShareActionSheet)localObject).setActionSheetTitle(paramContext.getString(2131694193));
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
      ((ShareActionSheet)localObject).setActionSheetItems(localArrayList1, localArrayList2);
      ((ShareActionSheet)localObject).setRowVisibility(0, 0, 0);
    }
  }
  
  private static void a(ooe paramooe)
  {
    if ((paramooe != null) && (paramooe.a() != null)) {
      paramooe.a().uR(2);
    }
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (!WXShareHelper.a().isWXinstalled()) {
      arxa.a().showToast(2131721935);
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      ThreadManager.getSubThreadHandler().post(new WeishiShareUtil.1(paramString3, String.valueOf(l), paramString1, paramString2, paramString4, paramInt));
      WXShareHelper.a().a(new ope());
      return;
      if (!WXShareHelper.a().isWXsupportApi()) {
        arxa.a().showToast(2131721936);
      }
    }
  }
  
  public static void b(Context paramContext, ooe paramooe)
  {
    if (opn.qH()) {
      return;
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = paramContext;
    localObject = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    ((ShareActionSheet)localObject).setActionSheetTitle("");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
    ((ShareActionSheet)localObject).setItemClickListenerV2(new opj(paramContext, paramooe));
    ((ShareActionSheet)localObject).setActionSheetItems(localArrayList1, localArrayList2);
    ((ShareActionSheet)localObject).setRowVisibility(8, 8, 0);
    paramContext = (Activity)paramContext;
    if (paramContext != null)
    {
      paramContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
      ((ShareActionSheet)localObject).setIntentForStartForwardRecentActivity(paramContext.getIntent());
    }
    ((ShareActionSheet)localObject).setOnShowListener(new opk(paramooe));
    ((ShareActionSheet)localObject).setCancelListener(new opl(paramooe));
    ((ShareActionSheet)localObject).setOnDismissListener(new opd(paramooe));
    ((ShareActionSheet)localObject).show();
  }
  
  private static void b(ooe paramooe)
  {
    if ((paramooe != null) && (paramooe.a() != null)) {
      paramooe.a().uS(2);
    }
  }
  
  public static void shareToQQ(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
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
      paramString2.putExtra("image_url_remote", paramString3);
      paramString2.putExtra("detail_url", paramString4);
    }
    paramContext.startActivity(paramString2);
  }
  
  public static void shareToQzone(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
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
    ((QZoneShareData)localObject).mTitle = paramString1;
    ((QZoneShareData)localObject).mSummary = paramString2;
    ((QZoneShareData)localObject).ER = new ArrayList();
    ((QZoneShareData)localObject).ER.add(paramString3);
    ((QZoneShareData)localObject).from = 0;
    ((QZoneShareData)localObject).targetUrl = paramString4;
    ((QZoneShareData)localObject).cMX = paramString5;
    avqq.a(paramContext, paramString5, (QZoneShareData)localObject, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opc
 * JD-Core Version:    0.7.0.1
 */