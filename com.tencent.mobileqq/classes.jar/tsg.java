import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class tsg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public tsg(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.getRootView().getHeight();
    int j = i - ((Rect)localObject).bottom;
    if ((this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.e != j))
    {
      localObject = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, j);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.a.e = j;
    }
    if (j > i / 3)
    {
      if (this.a.c) {
        this.a.c(false);
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Int == 2) {
          this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        }
        i = (int)UITools.b(BaseApplicationImpl.getApplication(), this.a.b + j);
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.c(this.a).c("setKeyboardHeight(" + i + ")");
        if (!this.a.d)
        {
          TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.d(this.a).c("reLocateForNative()");
          this.a.d = true;
        }
        return;
        this.a.c(true);
      }
    }
    this.a.c(false);
    if (this.a.jdField_a_of_type_Int == 2) {
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if (this.a.jdField_a_of_type_Int == 2)
    {
      i = (int)UITools.b(BaseApplicationImpl.getApplication(), this.a.b);
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.e(this.a).c("setKeyboardHeight(" + i + ")");
    }
    for (;;)
    {
      this.a.d = false;
      return;
      if (this.a.jdField_a_of_type_Int == 1) {
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.f(this.a).c("setKeyboardHeight(0)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsg
 * JD-Core Version:    0.7.0.1
 */