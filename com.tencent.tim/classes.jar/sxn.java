import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.b;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class sxn
  extends sye
  implements sxv
{
  protected TextView Bg;
  protected TextView Bh;
  protected TextView Bi;
  protected sxg a;
  protected sxm a;
  sxv a;
  protected boolean aOb;
  protected boolean aOc;
  public AbstractImageAdapter b;
  protected View bottomBar;
  protected ImageView forwardBtn;
  protected Activity mContext;
  private int mEdgePadding;
  protected GestureSelectGridView mGridView;
  private int mHorizontalSpacing;
  int mImageWidth;
  protected RelativeLayout mRoot;
  private int mVerticalSpacing;
  protected ImageView oS;
  protected ImageView oT;
  protected Dialog pd;
  protected aqju t;
  protected TextView title;
  
  public sxn(Activity paramActivity, sxm paramsxm)
  {
    this.jdField_a_of_type_Sxv = new sxt(this);
    this.mContext = paramActivity;
    this.jdField_a_of_type_Sxm = paramsxm;
  }
  
  private void E(ViewGroup paramViewGroup)
  {
    this.mRoot = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131561199, null));
    if (paramViewGroup == null) {
      this.mContext.addContentView(this.mRoot, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      setRootView(this.mRoot);
      this.title = ((TextView)this.mContext.findViewById(2131379769));
      this.Bg = ((TextView)this.mContext.findViewById(2131364687));
      this.Bh = ((TextView)this.mContext.findViewById(2131377932));
      this.forwardBtn = ((ImageView)this.mContext.findViewById(2131367525));
      this.oS = ((ImageView)this.mContext.findViewById(2131377624));
      this.oT = ((ImageView)this.mContext.findViewById(2131382210));
      this.bottomBar = this.mContext.findViewById(2131362562);
      this.Bi = ((TextView)this.mContext.findViewById(2131364477));
      this.mGridView = ((GestureSelectGridView)this.mContext.findViewById(2131362473));
      this.mGridView.setScrollBarStyle(0);
      this.mGridView.setNumColumns(4);
      this.mGridView.setColumnWidth(this.mImageWidth);
      this.mGridView.setHorizontalSpacing(this.mHorizontalSpacing);
      this.mGridView.setVerticalSpacing(this.mVerticalSpacing);
      this.mGridView.setPadding(this.mEdgePadding, this.mGridView.getPaddingTop(), this.mEdgePadding, this.mGridView.getPaddingBottom());
      this.mGridView.setOnItemClickListener(a());
      this.mGridView.setOnIndexChangedListener(a());
      this.b = a(this.mContext, this.mImageWidth);
      this.mGridView.setAdapter(this.b);
      this.title.setText(2131720472);
      bBP();
      bBQ();
      this.mRoot.setVisibility(4);
      return;
      paramViewGroup.addView(this.mRoot, 0);
    }
  }
  
  private void bBP()
  {
    if (this.Bg != null)
    {
      if ((this.jdField_a_of_type_Sxz == null) || (!this.jdField_a_of_type_Sxz.aOe)) {
        break label129;
      }
      this.Bi.setVisibility(0);
      this.Bi.setText("");
      ((ViewGroup.MarginLayoutParams)this.Bi.getLayoutParams()).setMargins(wja.dp2px(16.0F, this.mContext.getResources()), 0, 0, 0);
      this.Bg.setVisibility(8);
      this.Bi.setOnClickListener(new sxo(this));
    }
    for (;;)
    {
      if (this.Bh != null)
      {
        this.Bh.setVisibility(0);
        this.Bh.setText(2131690235);
        this.Bh.setOnClickListener(w());
      }
      return;
      label129:
      this.Bg.setVisibility(0);
      this.Bi.setVisibility(8);
      this.Bg.setText(2131690108);
      this.Bg.setOnClickListener(new sxp(this));
    }
  }
  
  private void bBQ()
  {
    if (this.aOc) {
      this.bottomBar.setVisibility(0);
    }
    for (;;)
    {
      this.forwardBtn.setOnClickListener(new sxq(this));
      this.oS.setOnClickListener(new sxr(this));
      if (this.oT != null) {
        this.oT.setOnClickListener(new sxs(this));
      }
      return;
      this.bottomBar.setVisibility(8);
    }
  }
  
  private void initConfig()
  {
    ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
    this.mEdgePadding = this.mContext.getResources().getDimensionPixelSize(2131297813);
    this.mHorizontalSpacing = this.mContext.getResources().getDimensionPixelSize(2131297814);
    this.mVerticalSpacing = this.mContext.getResources().getDimensionPixelSize(2131297815);
    this.mImageWidth = ((aqnm.getScreenWidth() - this.mEdgePadding * 2 - this.mHorizontalSpacing * 3) / 4);
  }
  
  protected abstract AbstractImageAdapter a(Activity paramActivity, int paramInt);
  
  protected abstract AdapterView.c a();
  
  protected abstract GestureSelectGridView.b a();
  
  public void bBR()
  {
    this.jdField_a_of_type_Sxz.a().a(this.jdField_a_of_type_Sxv);
  }
  
  protected abstract void bBS();
  
  protected abstract void bBT();
  
  protected abstract void bBU();
  
  public boolean back()
  {
    onBack();
    this.mContext.finish();
    if (this.aOb) {
      this.mContext.overridePendingTransition(2130772096, 2130772091);
    }
    for (;;)
    {
      return true;
      this.mContext.overridePendingTransition(2130771989, 2130771990);
    }
  }
  
  public void onBack() {}
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Sxg = this.jdField_a_of_type_Sxz.a();
    initConfig();
    E(paramViewGroup);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.aOc = false;
    this.b = null;
    this.jdField_a_of_type_Sxm = null;
  }
  
  public void onEnterAnimationEnd() {}
  
  public void onEnterAnimationStart() {}
  
  public void onExitAnimationEnd() {}
  
  public void onExitAnimationStart() {}
  
  public void onStart()
  {
    if ((this.mContext instanceof AIOGalleryActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImmerseTest", 2, "imagelist setColor blue");
      }
      int i;
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mRoot != null))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mRoot.getLayoutParams();
        i = ImmersiveUtils.getStatusBarHeight(this.mContext);
        if (localLayoutParams != null) {
          localLayoutParams.setMargins(0, i, 0, 0);
        }
        if ((this.jdField_a_of_type_Sxz != null) && (this.jdField_a_of_type_Sxz.cI != null) && (Build.VERSION.SDK_INT >= 16)) {
          this.jdField_a_of_type_Sxz.cI.setSystemUiVisibility(0);
        }
      }
      if (((AIOGalleryActivity)this.mContext).mSystemBarComp != null)
      {
        i = this.mContext.getResources().getColor(2131167361);
        ((AIOGalleryActivity)this.mContext).mSystemBarComp.setStatusColor(i);
        ((AIOGalleryActivity)this.mContext).mSystemBarComp.setStatusBarColor(i);
      }
    }
    this.title.setText(2131720472);
    if (this.mRoot != null) {
      this.mRoot.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onstart");
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.rootView.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onStop");
    }
  }
  
  public Rect q()
  {
    int i = this.mGridView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_Sxm.getSelectedIndex();
    View localView = this.mGridView.getChildAt(j - i);
    if (localView != null) {
      return sxx.getViewRect(localView);
    }
    return null;
  }
  
  protected abstract View.OnClickListener w();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxn
 * JD-Core Version:    0.7.0.1
 */