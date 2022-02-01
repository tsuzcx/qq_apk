package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import acfp;
import ahep;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import axov;
import axrf;
import axug;
import ayno;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;
import pre;
import rar;
import wja;

public class EditTextEffectView
  extends RecyclerView
  implements Handler.Callback
{
  public static final int eKI;
  public static final int eKJ;
  public static final int eKK;
  public Vector<DynamicTextConfigManager.DynamicTextConfigBean> X = new Vector();
  ahep jdField_a_of_type_Ahep;
  a jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a = null;
  axrf d = new ayno(this);
  public boolean dAe;
  int eKL = -1;
  private int eKx;
  public Handler mHandler = new Handler(this);
  public LinearLayoutManager mLayoutManager;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    eKJ = wja.dp2px(5.0F, localResources);
    eKI = wja.dp2px(5.0F, localResources);
    eKK = wja.dp2px(3.0F, localResources);
  }
  
  public EditTextEffectView(Context paramContext, ahep paramahep)
  {
    super(paramContext);
    this.jdField_a_of_type_Ahep = paramahep;
    setClipToPadding(false);
    init();
    ie();
    setClipChildren(false);
  }
  
  private List<DynamicTextConfigManager.DynamicTextConfigBean> bF(List<DynamicTextConfigManager.DynamicTextConfigBean> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (((DynamicTextConfigManager.DynamicTextConfigBean)localIterator.next()).text_id >= 29) {
        localIterator.remove();
      }
    }
    while (paramList.size() > 29) {
      paramList.remove(paramList.size() - 1);
    }
    return paramList;
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a.mDatas == null) {
      return null;
    }
    return (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a.mDatas.get(paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      ie();
    }
  }
  
  public void ie()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextEffectView", 2, "loadData");
    }
    DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)axov.a(7);
    if (!localDynamicTextConfigManager.aPL()) {
      localDynamicTextConfigManager.eOS();
    }
    this.X.clear();
    ArrayList localArrayList = localDynamicTextConfigManager.eM();
    localDynamicTextConfigManager.aK(localArrayList, this.dAe);
    this.X.addAll(bF(localArrayList));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a.setDatas(this.X);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a.notifyDataSetChanged();
  }
  
  @TargetApi(9)
  public void init()
  {
    setOverScrollMode(2);
    this.mLayoutManager = new LinearLayoutManager(getContext());
    this.mLayoutManager.setOrientation(0);
    setLayoutManager(this.mLayoutManager);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a = new a(this.jdField_a_of_type_Ahep);
    setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a);
  }
  
  public int mb(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a.mDatas != null))
    {
      int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a.mDatas.size();
      int i = 0;
      while (i < j)
      {
        if (((DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a.mDatas.get(i)).text_id == paramInt) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
    this.d = new axrf();
    localAppRuntime.registObserver(this.d);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    BaseApplicationImpl.getApplication().waitAppRuntime(null).unRegistObserver(this.d);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("EditTextEffectView", 2, "exittext panel visible");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("EditTextEffectView", 2, "exittext panel gone");
  }
  
  public void select(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a.mDatas != null) && (paramInt < this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a.mDatas.size()))
    {
      this.eKL = ((DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$a.mDatas.get(paramInt)).text_id;
      int j = this.mLayoutManager.getChildCount();
      int i = 0;
      label65:
      b localb;
      if (i < j)
      {
        localb = (b)getChildViewHolder(this.mLayoutManager.getChildAt(i));
        if (localb.position == paramInt) {
          break label109;
        }
        localb.setSelected(false);
      }
      for (;;)
      {
        i += 1;
        break label65;
        break;
        label109:
        localb.setSelected(true);
        rar.a("video_edit_new", "text_element", this.eKx, 0, new String[] { "0", String.valueOf(this.eKL) });
      }
    }
    QLog.e("EditTextEffectView", 1, "select position = " + paramInt + " no item");
  }
  
  public void setEditPhoto(boolean paramBoolean)
  {
    this.dAe = paramBoolean;
  }
  
  public void setOpIn(int paramInt)
  {
    this.eKx = paramInt;
  }
  
  public class a
    extends RecyclerView.Adapter<EditTextEffectView.b>
  {
    public DynamicTextConfigManager b;
    public ahep d;
    List<DynamicTextConfigManager.DynamicTextConfigBean> mDatas;
    
    public a(ahep paramahep)
    {
      this.d = paramahep;
      this.b = ((DynamicTextConfigManager)axov.a(7));
    }
    
    public EditTextEffectView.b a(ViewGroup paramViewGroup, int paramInt)
    {
      return new EditTextEffectView.b(LayoutInflater.from(EditTextEffectView.this.getContext()).inflate(2131561831, paramViewGroup, false), this.d);
    }
    
    public void a(EditTextEffectView.b paramb, int paramInt)
    {
      Object localObject = (DynamicTextConfigManager.DynamicTextConfigBean)this.mDatas.get(paramInt);
      paramb.jdField_c_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = ((DynamicTextConfigManager.DynamicTextConfigBean)localObject);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramb.itemView.getLayoutParams();
      localMarginLayoutParams.leftMargin = EditTextEffectView.eKJ;
      localMarginLayoutParams.bottomMargin = EditTextEffectView.eKI;
      localMarginLayoutParams.topMargin = EditTextEffectView.eKK;
      paramb.uh.setVisibility(8);
      if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id == EditTextEffectView.this.eKL)
      {
        paramb.IU.setVisibility(0);
        paramb.jd.setImageResource(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).iconDrawableId);
        if (!this.b.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) {
          break label206;
        }
        paramb.ta.setVisibility(8);
        label117:
        paramb.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
        paramb.position = paramInt;
        localObject = axug.gU(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id);
        if (localObject == null) {
          break label217;
        }
        paramb.itemView.setContentDescription(acfp.m(2131705475) + (String)localObject + acfp.m(2131705476));
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
        return;
        paramb.IU.setVisibility(8);
        break;
        label206:
        paramb.ta.setVisibility(0);
        break label117;
        label217:
        paramb.itemView.setContentDescription(null);
      }
    }
    
    public int getItemCount()
    {
      if (this.mDatas == null) {
        return 0;
      }
      return this.mDatas.size();
    }
    
    public void setDatas(List<DynamicTextConfigManager.DynamicTextConfigBean> paramList)
    {
      this.mDatas = paramList;
    }
  }
  
  public static class b
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    ImageView IU;
    ahep jdField_c_of_type_Ahep;
    public DynamicTextConfigManager.DynamicTextConfigBean c;
    QIMCommonLoadingView jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView;
    View itemView;
    ImageView jd;
    int position;
    View progress;
    ImageView ta;
    ImageView uh;
    
    public b(View paramView, ahep paramahep)
    {
      super();
      this.jdField_c_of_type_Ahep = paramahep;
      this.itemView = paramView;
      this.jd = ((ImageView)paramView.findViewById(2131366279));
      this.uh = ((ImageView)paramView.findViewById(2131366280));
      this.IU = ((ImageView)paramView.findViewById(2131366282));
      this.progress = paramView.findViewById(2131366281);
      this.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131370811));
      this.ta = ((ImageView)paramView.findViewById(2131369117));
      paramView.setOnClickListener(this);
      paramahep = (RelativeLayout.LayoutParams)this.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.IU.getLayoutParams();
      paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      paramahep.width = paramView.width;
      paramahep.height = paramView.height;
      paramahep.addRule(10);
      paramahep.addRule(9);
      paramahep.addRule(12);
      paramahep.addRule(11);
      this.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setLayoutParams(paramahep);
      localLayoutParams.width = paramView.width;
      localLayoutParams.height = paramView.height;
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(11);
      this.IU.setLayoutParams(localLayoutParams);
    }
    
    public void ZH(boolean paramBoolean)
    {
      if (this.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getVisibility() != 8) {
        this.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      }
      if (paramBoolean) {
        if (this.ta.getVisibility() != 8) {
          this.ta.setVisibility(8);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DText", 2, "finish download pos is: " + this.position);
        }
        return;
        if (this.ta.getVisibility() != 0) {
          this.ta.setVisibility(0);
        }
      }
    }
    
    public void bD(float paramFloat)
    {
      if (this.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getVisibility() != 0) {
        this.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
      }
      this.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setProgress((int)paramFloat);
      int i = this.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getMeasuredWidth();
      int j = this.jdField_c_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getMeasuredHeight();
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "updateProgress progress is: " + paramFloat + " pos is: " + this.position + " width is: " + i + "height is: " + j);
      }
    }
    
    public void onClick(View paramView)
    {
      if (paramView == this.itemView)
      {
        if (this.jdField_c_of_type_Ahep != null) {
          this.jdField_c_of_type_Ahep.h(paramView, getAdapterPosition(), -1);
        }
        rar.a("video_edit_text", "clk_textIcon", 0, 0, new String[] { (String)pre.a().a("EditVideoDTextFace.mSrcFrom"), String.valueOf(getAdapterPosition() + 1), "", "" });
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public void setSelected(boolean paramBoolean)
    {
      if (paramBoolean) {
        if (this.IU.getVisibility() != 0) {
          this.IU.setVisibility(0);
        }
      }
      while (this.IU.getVisibility() == 8) {
        return;
      }
      this.IU.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView
 * JD-Core Version:    0.7.0.1
 */