import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.AdapterView.e;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.b;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class agxw
  extends agxu
{
  private DragGallery jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery;
  private DragView.b jdField_a_of_type_ComTencentWidgetDragView$b = new agxx(this);
  private DragView jdField_a_of_type_ComTencentWidgetDragView;
  private ImageButton ay;
  private agse b;
  private boolean cfL;
  private boolean cfM;
  private boolean cfN;
  private LinearLayout iU;
  private RelativeLayout kq;
  
  public agxw(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void F(View.OnClickListener paramOnClickListener)
  {
    this.ay.setOnClickListener(paramOnClickListener);
  }
  
  public void JJ(boolean paramBoolean)
  {
    int j = 0;
    LinearLayout localLinearLayout;
    if (this.iU != null)
    {
      if ((!paramBoolean) || (this.cfN)) {
        break label46;
      }
      i = 1;
      localLinearLayout = this.iU;
      if (i == 0) {
        break label51;
      }
    }
    label46:
    label51:
    for (int i = j;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      this.cfL = paramBoolean;
      return;
      i = 0;
      break;
    }
  }
  
  public void JK(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.cfN)) {}
    for (boolean bool = true;; bool = false)
    {
      super.JK(bool);
      this.cfM = paramBoolean;
      return;
    }
  }
  
  public void JN(boolean paramBoolean)
  {
    ImageButton localImageButton = this.ay;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void JO(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentWidgetDragView != null) {
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(u());
      }
    }
    while (this.jdField_a_of_type_ComTencentWidgetDragView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(null);
  }
  
  public void JP(boolean paramBoolean)
  {
    Rect localRect;
    int i;
    if (this.jdField_a_of_type_ComTencentWidgetDragView != null)
    {
      localRect = u();
      if (localRect != null)
      {
        if (paramBoolean) {
          break label101;
        }
        localRect.top -= ImmersiveUtils.getStatusBarHeight(this.mContext);
        localRect.bottom -= ImmersiveUtils.getStatusBarHeight(this.mContext);
        if ((ayxa.hasInitHasNotch) && (ayxa.sHasNotch))
        {
          i = ayxa.getNotchInScreenHeight(this.mContext);
          localRect.top += i;
        }
      }
    }
    for (localRect.bottom = (i + localRect.bottom);; localRect.bottom -= i)
    {
      label101:
      do
      {
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(localRect);
        return;
        localRect.top += ImmersiveUtils.getStatusBarHeight(this.mContext);
        localRect.bottom += ImmersiveUtils.getStatusBarHeight(this.mContext);
      } while ((!ayxa.hasInitHasNotch) || (!ayxa.sHasNotch));
      i = ayxa.getNotchInScreenHeight(this.mContext);
      localRect.top -= i;
    }
  }
  
  public void ON(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(paramInt);
  }
  
  public void a(AdapterView.c paramc)
  {
    if (paramc != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemClickListener(paramc);
    }
  }
  
  public void a(AdapterView.d paramd)
  {
    if (paramd != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemLongClickListener(paramd);
    }
  }
  
  public void a(AdapterView.e parame)
  {
    if (parame != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemSelectedListener(parame);
    }
  }
  
  public void dkq()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: PictureFileViewer initFileView");
    if (this.CS == null)
    {
      this.CS = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131561065, this.mRootView, false);
      this.kq = ((RelativeLayout)this.CS.findViewById(2131367044));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery = ((DragGallery)this.CS.findViewById(2131367833));
      this.ay = ((ImageButton)this.CS.findViewById(2131366209));
      this.b = new agse(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setAdapter(this.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnNoBlankListener(this.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSpacing(this.CS.getResources().getDimensionPixelSize(2131297406));
      this.iU = ((LinearLayout)this.CS.findViewById(2131372658));
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)this.CS.findViewById(2131366139));
      Rect localRect = u();
      if (localRect != null)
      {
        localRect.top -= ImmersiveUtils.getStatusBarHeight(this.mContext);
        localRect.bottom -= ImmersiveUtils.getStatusBarHeight(this.mContext);
      }
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(localRect);
      this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
      this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this.jdField_a_of_type_ComTencentWidgetDragView$b);
    }
  }
  
  public void dkt()
  {
    if (this.b != null) {
      this.b.notifyDataSetChanged();
    }
  }
  
  public void dku()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.reset();
  }
  
  public void kN(List<aguk.a> paramList)
  {
    this.b.kK(paramList);
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxw
 * JD-Core Version:    0.7.0.1
 */