package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import aqnm;
import awtq;
import axbu;
import axgi;
import axgn;
import axgn.a;
import axgt;
import axgu;
import axim;
import axip;
import axiy;
import java.util.List;

public class AEPlayShowPageView
  extends FrameLayout
{
  private static final axgn.a jdField_b_of_type_Axgn$a = a(1);
  private static final axgn.a c = a(2);
  private RecyclerView M;
  private List<axbu> MD;
  private axgn jdField_b_of_type_Axgn;
  private int bvK = 2;
  private GridLayoutManager d;
  private axgi e;
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, @NonNull axgi paramaxgi, int paramInt2, @NonNull List<axbu> paramList)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(paramaxgi, paramInt2, paramList);
    initViews(paramContext);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull axgi paramaxgi, int paramInt, @NonNull List<axbu> paramList)
  {
    this(paramContext, paramAttributeSet, 0, paramaxgi, paramInt, paramList);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @NonNull axgi paramaxgi, int paramInt, @NonNull List<axbu> paramList)
  {
    this(paramContext, null, paramaxgi, paramInt, paramList);
  }
  
  private static axgn.a a(int paramInt)
  {
    int j = aqnm.dip2px(10.0F);
    int k = aqnm.dip2px(4.0F);
    int m = (int)(k * 0.96F);
    if (paramInt == 1) {}
    for (int i = aqnm.getScreenWidth() - j * 2 - k * 2;; i = (aqnm.getScreenWidth() - j * 2 - k * 4) / 2)
    {
      int n = (int)(i * 0.96F * 59.0F / 34.0F);
      axgn.a locala = new axgn.a();
      locala.itemWidth = (i + k * 2);
      locala.itemHeight = (m * 2 + n);
      locala.itemHorizontalPadding = k;
      locala.eEQ = m;
      if (paramInt == 1) {
        locala.eEQ = j;
      }
      return locala;
    }
  }
  
  private void a(@NonNull axgi paramaxgi, int paramInt, @NonNull List<axbu> paramList)
  {
    this.e = paramaxgi;
    this.bvK = paramInt;
    this.MD = paramList;
  }
  
  private void eJH()
  {
    if (this.e == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.e.a(65537, new Object[0]);
      } while (!(localObject instanceof awtq));
      localObject = (awtq)localObject;
    } while ((((awtq)localObject).getActivity() == null) || (((awtq)localObject).getActivity().getIntent() == null));
    ((awtq)localObject).getActivity().getIntent().putExtra("KEY_CURRENT_SELECT_ID", "");
    ((awtq)localObject).getActivity().getIntent().putExtra("KEY_CURRENT_TYPE", "");
  }
  
  private void initViews(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558600, this, true);
    this.M = ((RecyclerView)findViewById(2131362316));
    axiy.d("AEPlayShowPart", "rv toString " + this.M.toString());
    this.M.addOnScrollListener(new axgt(this));
    if (this.bvK == 1)
    {
      this.d = new GridLayoutManager(paramContext, 1, 1, false);
      this.M.setLayoutManager(this.d);
      if (this.bvK != 1) {
        break label198;
      }
    }
    label198:
    for (axgn.a locala = new axgn.a(jdField_b_of_type_Axgn$a);; locala = new axgn.a(c))
    {
      this.M.addItemDecoration(new axgu(this, locala));
      this.jdField_b_of_type_Axgn = new axgn(paramContext, this.e, locala, this.bvK);
      this.M.setAdapter(this.jdField_b_of_type_Axgn);
      bJ(this.MD);
      return;
      this.d = new GridLayoutManager(paramContext, 2, 1, false);
      break;
    }
  }
  
  public void Nq(int paramInt)
  {
    if (this.M != null) {
      this.M.scrollTo(0, paramInt);
    }
  }
  
  public void adN(int paramInt)
  {
    if (this.M != null)
    {
      if (this.d != null) {
        this.d.scrollToPositionWithOffset(paramInt, 0);
      }
      axiy.d("AEPlayShowPart", "out........" + this.M.toString());
      this.M.post(new AEPlayShowPageView.3(this, paramInt));
    }
  }
  
  public void bJ(@NonNull List<axbu> paramList)
  {
    if (this.jdField_b_of_type_Axgn != null) {
      this.jdField_b_of_type_Axgn.oB(paramList);
    }
  }
  
  public void eJF()
  {
    this.jdField_b_of_type_Axgn.ekV();
  }
  
  public void eJG()
  {
    int i = this.d.findFirstVisibleItemPosition();
    int j = this.d.findLastVisibleItemPosition();
    if ((this.MD == null) || (i < 0) || (j < 0)) {}
    for (;;)
    {
      return;
      while ((i < this.MD.size()) && (i <= j))
      {
        axbu localaxbu = (axbu)this.MD.get(i);
        axip.a().LB(localaxbu.eEy);
        axip.a().adX(i + 1);
        axim.a().acN(localaxbu.id);
        i += 1;
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.M != null) {
      this.M.removeCallbacks(null);
    }
    if (this.jdField_b_of_type_Axgn != null) {
      this.jdField_b_of_type_Axgn.onDestroy();
    }
  }
  
  public void setTabId(String paramString)
  {
    this.jdField_b_of_type_Axgn.acz(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPageView
 * JD-Core Version:    0.7.0.1
 */