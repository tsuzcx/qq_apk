import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheet.a;
import java.util.List;

public class armb
  implements ShareActionSheet
{
  private ShareActionSheet h;
  
  public armb(ShareActionSheet paramShareActionSheet)
  {
    this.h = paramShareActionSheet;
  }
  
  public void dismiss()
  {
    this.h.dismiss();
  }
  
  public void dismissImmediately()
  {
    this.h.dismissImmediately();
  }
  
  public View findViewById(int paramInt)
  {
    return this.h.findViewById(paramInt);
  }
  
  public ausj getActionSheet()
  {
    return this.h.getActionSheet();
  }
  
  public int getIconWidth()
  {
    return this.h.getIconWidth();
  }
  
  public String getOpenSource()
  {
    return this.h.getOpenSource();
  }
  
  public Window getWindow()
  {
    return this.h.getWindow();
  }
  
  public void hideTitle()
  {
    this.h.hideTitle();
  }
  
  public boolean isShowing()
  {
    return this.h.isShowing();
  }
  
  public void onConfigurationChanged()
  {
    this.h.onConfigurationChanged();
  }
  
  public void refresh()
  {
    this.h.refresh();
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    this.h.setActionSheetItems(paramList1, paramList2);
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.h.setActionSheetItems(paramArrayOfList);
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    this.h.setActionSheetTitle(paramCharSequence);
  }
  
  public void setAdvBgColor(int paramInt)
  {
    this.h.setAdvBgColor(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.h.setAdvView(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.a parama)
  {
    this.h.setBottomBarInterface(parama);
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.h.setCancelListener(paramOnCancelListener);
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    this.h.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
  }
  
  public void setExtras(Bundle paramBundle)
  {
    this.h.setExtras(paramBundle);
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.h.setIconMarginLeftRight(paramInt);
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    this.h.setIntentForStartForwardRecentActivity(paramIntent);
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.h.setItemClickListener(paramOnItemClickListener);
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.h.setItemClickListenerV2(paramOnItemClickListener);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.h.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.h.setOnShowListener(paramOnShowListener);
  }
  
  public void setOpenSource(String paramString)
  {
    this.h.setOpenSource(paramString);
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    this.h.setRowMarginLeftRight(paramInt);
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    this.h.setRowVisibility(paramInt1, paramInt2, paramInt3);
  }
  
  public void show()
  {
    this.h.show();
  }
  
  public void updateUI()
  {
    this.h.updateUI();
  }
  
  public void updateUIIfShowing()
  {
    this.h.updateUIIfShowing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armb
 * JD-Core Version:    0.7.0.1
 */