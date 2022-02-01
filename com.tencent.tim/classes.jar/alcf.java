import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class alcf
{
  public static String SHARE_URL = "https://ti.qq.com/specialtag/share.html?id=%s";
  public Bitmap N;
  public alcf.a a;
  public Activity mActivity;
  public QQAppInterface mApp;
  Context mContext;
  ShareActionSheetBuilder mShareActionSheet = null;
  
  public alcf(Context paramContext, QQAppInterface paramQQAppInterface, Activity paramActivity, alcf.a parama)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mActivity = paramActivity;
    this.a = parama;
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
  
  @Nullable
  private String xQ()
  {
    Object localObject = null;
    try
    {
      String str = "temp_qrcode_share_" + System.currentTimeMillis() + this.mApp.getCurrentAccountUin() + ".png";
      str = rwt.a(this.mActivity, str, this.N);
      localObject = str;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ShareHelper", 2, localOutOfMemoryError.getMessage());
    }
    return localObject;
    return null;
  }
  
  public void ad(Bitmap paramBitmap)
  {
    this.N = paramBitmap;
  }
  
  public void c(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.mShareActionSheet == null)
    {
      alcg localalcg = new alcg(this);
      paramOnDismissListener = new alch(this, paramOnDismissListener);
      this.mShareActionSheet = new ShareActionSheetBuilder((Activity)this.mContext);
      this.mShareActionSheet.setActionSheetTitle(this.mContext.getString(2131720177));
      this.mShareActionSheet.setActionSheetItems(a(this.mContext));
      this.mShareActionSheet.setItemClickListener(localalcg);
      this.mShareActionSheet.setOnDismissListener(paramOnDismissListener);
    }
    try
    {
      if (!this.mShareActionSheet.getActionSheet().isShowing()) {
        this.mShareActionSheet.show();
      }
      return;
    }
    catch (Exception paramOnDismissListener)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + paramOnDismissListener);
    }
  }
  
  public static abstract interface a
  {
    public abstract void iW(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alcf
 * JD-Core Version:    0.7.0.1
 */