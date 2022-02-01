package dov.com.qq.im.aeeditor.module.filter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import aqiw;
import axim;
import axiy;
import axiz;
import axmp;
import axmq;
import axmr;
import axmw;
import axmx;
import axmx.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AEEditorFilterControlPanel
  extends FrameLayout
  implements View.OnClickListener, axmx.a
{
  private static final String TAG = AEEditorFilterControlPanel.class.getSimpleName();
  private int AS = -1;
  private axmw jdField_a_of_type_Axmw;
  private axmx jdField_a_of_type_Axmx;
  private AEEditorFilterBean jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean = AEEditorFilterBean.createAiFilterInstance();
  private a jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a;
  private TextView ahn;
  private AEEditorFilterBean b = AEEditorFilterBean.createNonFilterInstance();
  private AEEditorFilterBean c = AEEditorFilterBean.createComicsFilterInstance();
  private boolean cSH;
  private List<AEEditorFilterBean> filters = new ArrayList();
  private Dialog g;
  private Button hW;
  private RecyclerView recyclerView;
  private SeekBar v;
  
  public AEEditorFilterControlPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public AEEditorFilterControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public AEEditorFilterControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void hideLoading()
  {
    if ((this.g != null) && (this.g.isShowing())) {
      this.g.dismiss();
    }
  }
  
  private void initView(Context paramContext)
  {
    this.cSH = axiz.aOK();
    View localView = View.inflate(paramContext, 2131558610, this);
    this.v = ((SeekBar)localView.findViewById(2131367095));
    this.v.setVisibility(4);
    this.v.setOnSeekBarChangeListener(new axmp(this));
    this.hW = ((Button)localView.findViewById(2131362881));
    this.hW.setOnClickListener(this);
    this.recyclerView = ((RecyclerView)localView.findViewById(2131367094));
    paramContext = new LinearLayoutManager(paramContext, 0, false);
    this.recyclerView.setLayoutManager(paramContext);
  }
  
  private void showLoading(String paramString)
  {
    if (this.g == null)
    {
      this.g = new ReportDialog(getContext(), 2131756467);
      this.g.setCancelable(false);
      this.g.setCanceledOnTouchOutside(false);
      this.g.setContentView(2131559761);
    }
    TextView localTextView = (TextView)this.g.findViewById(2131373180);
    if (!TextUtils.isEmpty(paramString)) {
      localTextView.setText(paramString);
    }
    for (;;)
    {
      this.g.show();
      return;
      localTextView.setText(2131696924);
    }
  }
  
  public void Nq(int paramInt)
  {
    this.recyclerView.scrollToPosition(paramInt);
  }
  
  public void V(TextView paramTextView)
  {
    this.ahn = paramTextView;
  }
  
  public void YA(boolean paramBoolean)
  {
    SeekBar localSeekBar = this.v;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localSeekBar.setVisibility(i);
      if ((this.ahn != null) && (!paramBoolean)) {
        this.ahn.setVisibility(4);
      }
      return;
    }
  }
  
  public void Yz(boolean paramBoolean)
  {
    Button localButton = this.hW;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localButton.setVisibility(i);
      return;
    }
  }
  
  public boolean a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.AIFilter)
    {
      axiy.i(TAG, "select ai filter");
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a == null) {
        break label370;
      }
      bool1 = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a.aOV();
      axim.a().acJ(paramAEEditorFilterBean.getSid());
    }
    for (;;)
    {
      if (bool1)
      {
        if (this.jdField_a_of_type_Axmw != null) {
          bool2 = this.jdField_a_of_type_Axmw.bC(this.AS, paramInt);
        }
        if ((bool2) && (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a != null)) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a.eME();
        }
        this.AS = paramInt;
      }
      return bool1;
      if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NON)
      {
        axiy.i(TAG, "select none filter");
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a != null)
        {
          this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a.eMB();
          axim.a().acJ(paramAEEditorFilterBean.getSid());
          bool1 = true;
        }
      }
      else if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.COLOR)
      {
        axiy.i(TAG, "select color filter: " + paramAEEditorFilterBean.getLutName());
        String str = axmr.a().a(paramAEEditorFilterBean);
        if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
        {
          if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a != null)
          {
            this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a.a(paramInt, str, paramAEEditorFilterBean.getDefaultAlpha(), paramAEEditorFilterBean);
            axim.a().acJ(paramAEEditorFilterBean.getSid());
            bool1 = true;
          }
        }
        else
        {
          if (!aqiw.isNetworkAvailable())
          {
            QQToast.a(getContext(), "资源下载中，请稍后再试", 0).show();
            continue;
          }
          showLoading("资源下载中");
          axmr.a().a(paramAEEditorFilterBean.getSid(), new axmq(this, paramInt, str, paramAEEditorFilterBean));
        }
      }
      else if (paramAEEditorFilterBean.type == AEEditorFilterBean.FilterID.Comics)
      {
        axiy.i(TAG, "select comics filter");
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a != null)
        {
          bool1 = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a.aOW();
          axim.a().acJ(paramAEEditorFilterBean.getSid());
          continue;
        }
      }
      label370:
      bool1 = true;
    }
  }
  
  public boolean aOX()
  {
    return getSelectedIndex() == 1;
  }
  
  public boolean aOY()
  {
    return getSelectedIndex() == 0;
  }
  
  public boolean aOZ()
  {
    return getSelectedIndex() == 2;
  }
  
  public void ade(String paramString)
  {
    axiy.i(TAG, "selectFilter---" + paramString);
    if (TextUtils.isEmpty(paramString)) {}
    label104:
    for (;;)
    {
      return;
      int i = 0;
      for (;;)
      {
        if (i >= this.filters.size()) {
          break label104;
        }
        if (paramString.equals(((AEEditorFilterBean)this.filters.get(i)).getSid()))
        {
          if (!a(i, (AEEditorFilterBean)this.filters.get(i))) {
            break;
          }
          select(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public int getSelectedIndex()
  {
    return this.jdField_a_of_type_Axmx.getSelectedIndex();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.hW.isEnabled()) && (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a != null) && ((this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a instanceof b))) {
        ((b)this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a).eMz();
      }
    }
  }
  
  public void select(int paramInt)
  {
    this.recyclerView.scrollToPosition(paramInt);
    this.jdField_a_of_type_Axmx.setSelectedIndex(paramInt);
  }
  
  public void setFilterChangedComparator(axmw paramaxmw)
  {
    this.jdField_a_of_type_Axmw = paramaxmw;
  }
  
  public void setFilterControlListener(a parama)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel$a = parama;
  }
  
  public void setFiltersData(List<AEEditorFilterBean> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.filters.clear();
      this.filters.add(this.b);
      this.filters.add(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      if (paramBoolean) {
        this.filters.add(this.c);
      }
      this.filters.addAll(paramList);
    }
    if (this.jdField_a_of_type_Axmx != null) {
      this.jdField_a_of_type_Axmx.notifyDataSetChanged();
    }
  }
  
  public void setSeekBarValue(float paramFloat)
  {
    this.v.setProgress((int)(100.0F * paramFloat));
  }
  
  public void tb(boolean paramBoolean)
  {
    this.filters.clear();
    this.filters.add(this.b);
    this.filters.add(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
    if (paramBoolean) {
      this.filters.add(this.c);
    }
    this.jdField_a_of_type_Axmx = new axmx(this.filters, 0, this);
    this.recyclerView.setAdapter(this.jdField_a_of_type_Axmx);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString, float paramFloat, AEEditorFilterBean paramAEEditorFilterBean);
    
    public abstract boolean aOV();
    
    public abstract boolean aOW();
    
    public abstract void eMB();
    
    public abstract void eMC();
    
    public abstract void eMD();
    
    public abstract void eME();
    
    public abstract void v(int paramInt, float paramFloat);
  }
  
  public static abstract interface b
    extends AEEditorFilterControlPanel.a
  {
    public abstract void eMz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel
 * JD-Core Version:    0.7.0.1
 */