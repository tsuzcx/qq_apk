import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ajam
{
  public static final String bQt = acfp.m(2131714399);
  public String bQr;
  public String bQs;
  public Bitmap fu;
  QQAppInterface mApp;
  Context mContext;
  ShareActionSheetBuilder mShareActionSheet = null;
  public String shareDesc;
  public String shareTitle;
  public String shareUrl;
  public String srcUrl = "";
  
  public ajam(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698630);
    localActionSheetItem.icon = 2130839252;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698643);
    localActionSheetItem.icon = 2130839253;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698652);
    localActionSheetItem.icon = 2130839256;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698633);
    localActionSheetItem.icon = 2130839249;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private boolean aqk()
  {
    return (!TextUtils.isEmpty(this.shareUrl)) && (!TextUtils.isEmpty(this.shareTitle)) && (!TextUtils.isEmpty(this.shareDesc)) && (!TextUtils.isEmpty(this.bQs));
  }
  
  public static String c(Long paramLong)
  {
    if (paramLong == null) {
      return null;
    }
    return new SimpleDateFormat("yyyyMMdd").format(paramLong);
  }
  
  private void dvT()
  {
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(114).a(this.shareTitle).e(this.shareUrl).a();
    localAbsShareMsg.mSourceName = this.bQs;
    localAbsShareMsg.mSourceAction = "web";
    localAbsShareMsg.mSourceUrl = this.srcUrl;
    Object localObject = anrd.a(2);
    ((anqv)localObject).aU(this.bQr, this.shareTitle, this.shareDesc);
    localAbsShareMsg.addItem((anqu)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("forward_type", -3);
    ((Intent)localObject).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
    ((Intent)localObject).putExtra("forwardDirect", true);
    ahgq.f((Activity)this.mContext, (Intent)localObject, 21);
  }
  
  private void dvU()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.bQr)) {
      localArrayList.add(this.bQr);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.shareTitle);
    localBundle.putString("desc", this.shareDesc);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", this.shareUrl);
    localBundle.putString("url", this.shareUrl);
    localBundle.putStringArrayList("image_url", localArrayList);
    avqq.a(this.mApp, this.mContext, localBundle, null);
  }
  
  private void dvV()
  {
    long l = System.currentTimeMillis();
    WXShareHelper.a().d(String.valueOf(l), this.shareTitle, this.fu, this.shareDesc, this.shareUrl);
  }
  
  private void dvW()
  {
    long l = System.currentTimeMillis();
    WXShareHelper.a().c(String.valueOf(l), this.shareTitle, this.fu, this.shareDesc, this.shareUrl);
  }
  
  public static Bitmap e(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Object localObject3;
    if (paramDrawable == null)
    {
      localObject3 = null;
      return localObject3;
    }
    Object localObject1;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject1 = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject1).getBitmap() != null) {
        return ((BitmapDrawable)localObject1).getBitmap();
      }
    }
    for (;;)
    {
      try
      {
        if ((paramDrawable.getIntrinsicWidth() > 0) && (paramDrawable.getIntrinsicHeight() > 0)) {
          continue;
        }
        localObject1 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Rect localRect;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ShareHelper", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
        Object localObject2 = null;
        continue;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject3 = new Canvas((Bitmap)localObject1);
      localRect = paramDrawable.copyBounds();
      paramDrawable.setBounds(0, 0, ((Canvas)localObject3).getWidth(), ((Canvas)localObject3).getHeight());
      paramDrawable.draw((Canvas)localObject3);
      paramDrawable.setBounds(localRect);
      return localObject1;
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
  }
  
  private static String f(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    int k;
    for (int i = 0; j < paramArrayOfString.length; i = k)
    {
      k = i;
      if (paramArrayOfString[j].length() > i) {
        k = paramArrayOfString[j].length();
      }
      j += 1;
    }
    j = 0;
    while (j < i)
    {
      k = 0;
      while (k < paramArrayOfString.length)
      {
        if (paramArrayOfString[k].length() > j) {
          localStringBuilder.append(paramArrayOfString[k].charAt(j));
        }
        k += 1;
      }
      j += 1;
    }
    return lN(localStringBuilder.toString());
  }
  
  public static String g(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramArrayOfString[i] = lN(paramArrayOfString[i]);
      i += 1;
    }
    return f(paramArrayOfString);
  }
  
  private static String lN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(Base64.encodeToString(paramString.getBytes(), 3).replace("=", ""));
    char c = localStringBuilder.charAt(0);
    localStringBuilder.deleteCharAt(0);
    localStringBuilder.append(c);
    if (QLog.isColorLevel()) {
      QLog.i("ShareHelper", 4, "encodeOne src:" + Base64.encodeToString(paramString.getBytes(), 0) + " dst:" + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bitmap paramBitmap)
  {
    this.shareUrl = paramString3;
    this.shareTitle = paramString1;
    this.shareDesc = paramString2;
    this.bQr = paramString4;
    this.bQs = paramString5;
    this.fu = paramBitmap;
  }
  
  public void c(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!aqk()) {
      QQToast.a(this.mContext, acfp.m(2131714400), 0).show();
    }
    do
    {
      for (;;)
      {
        return;
        if (this.mShareActionSheet == null)
        {
          ajan localajan = new ajan(this);
          paramOnDismissListener = new ajao(this, paramOnDismissListener);
          this.mShareActionSheet = new ShareActionSheetBuilder((Activity)this.mContext);
          this.mShareActionSheet.setActionSheetTitle(this.mContext.getString(2131720177));
          this.mShareActionSheet.setActionSheetItems(a(this.mContext));
          this.mShareActionSheet.setItemClickListener(localajan);
          this.mShareActionSheet.setOnDismissListener(paramOnDismissListener);
        }
        try
        {
          if (!this.mShareActionSheet.getActionSheet().isShowing())
          {
            this.mShareActionSheet.show();
            return;
          }
        }
        catch (Exception paramOnDismissListener) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + paramOnDismissListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajam
 * JD-Core Version:    0.7.0.1
 */