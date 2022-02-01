import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.smallscreen.BaseSmallScreenService;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout.a;
import com.tencent.qphone.base.util.QLog;

public class ivq
{
  protected String TAG;
  public SmallScreenRelativeLayout a;
  public ivu a;
  protected int mHeight;
  protected int mLayout;
  protected int mWidth;
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, SmallScreenRelativeLayout.a parama)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = ((SmallScreenRelativeLayout)paramLayoutInflater.inflate(this.mLayout, null));
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.onCreate();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setFloatListener(parama);
    this.jdField_a_of_type_Ivu = new ivu(paramContext, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setIsRotateSize(true);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.mWidth, this.mHeight);
    setLayoutParams(this.jdField_a_of_type_Ivu.b());
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.mWidth, this.mHeight);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.updateLayout();
  }
  
  public boolean isVisible()
  {
    return (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getIsShow());
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Ivu.arg();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.onDestroy();
    this.jdField_a_of_type_Ivu = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
  }
  
  public void setLayoutParams(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.flags = 136;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramLayoutParams.type = 2038;
      return;
    }
    if (ivv.vI()) {}
    for (int i = 2005;; i = 2002)
    {
      paramLayoutParams.type = i;
      return;
    }
  }
  
  public void v(boolean paramBoolean, int paramInt)
  {
    boolean bool = isVisible();
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Ivu.vH()) {
        this.jdField_a_of_type_Ivu.vG();
      }
      if (!bool)
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(paramInt);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.show();
        if (QLog.isDevelopLevel()) {
          QLog.w(this.TAG, 4, "showOrHide, show toast view , tag[" + this.TAG + "]");
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!bool);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.hide();
    } while (!QLog.isDevelopLevel());
    QLog.w(this.TAG, 4, "showOrHide, hide toast view , tag[" + this.TAG + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivq
 * JD-Core Version:    0.7.0.1
 */