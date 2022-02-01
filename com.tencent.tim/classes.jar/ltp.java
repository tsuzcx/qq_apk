import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView.b;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.6;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.7;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.8;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.SideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ltp
  extends ViewBase
{
  private String TAG = "RvPolymericContainer";
  private SizeValue jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
  private ltx jdField_a_of_type_Ltx;
  private lty jdField_a_of_type_Lty;
  private lug jdField_a_of_type_Lug;
  private int aPJ = 0;
  private int aPK = 3000;
  private int aPL = 1000;
  private int aPM = Utils.rp2px(16.0D);
  private int aPN = Utils.rp2px(2.5D);
  private int aPO = Utils.rp2px(4.0D);
  private int aPP = Utils.rp2px(12.0D);
  private String afH;
  private String afI;
  private String afJ;
  private String afK = "#80FFFFFF";
  private String afL = "#FF07D0B0";
  private boolean akX;
  private boolean akY;
  private boolean akZ;
  private boolean ala;
  private boolean alb;
  private ProteusRecycleView.b jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView$b;
  private ProteusRecycleView jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView;
  private SizeValue jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
  private Drawable cA;
  private Drawable cB;
  private int[] di = new int[4];
  private RelativeLayout fd;
  private boolean isHorizontal = true;
  private LinearLayout mIndicatorContainer;
  private int mIndicatorHeight = Utils.rp2px(3.0D);
  private RecyclerView.OnScrollListener mScrollListener = new ltq(this);
  
  public ltp(VafContext paramVafContext)
  {
    super(paramVafContext);
    b(paramVafContext);
  }
  
  private void G(Runnable paramRunnable)
  {
    if (!this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.isComputingLayout())
    {
      paramRunnable.run();
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.postDelayed(new RvPolymericContainer.8(this, paramRunnable), 100L);
  }
  
  private void aNr()
  {
    int i = 0;
    if (this.mIndicatorContainer.getVisibility() != 0) {}
    for (;;)
    {
      return;
      int m = this.jdField_a_of_type_Lty.getDataCount();
      int k = this.mIndicatorContainer.getChildCount();
      if (m <= 1)
      {
        while (i < k)
        {
          this.mIndicatorContainer.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
      else
      {
        if (m > k)
        {
          Context localContext = this.mIndicatorContainer.getContext();
          int n = this.aPM;
          int i1 = this.mIndicatorHeight;
          i = k;
          if (i < m)
          {
            View localView = new View(localContext);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n, i1);
            int j;
            if (i == 0)
            {
              j = 0;
              label126:
              localLayoutParams.leftMargin = j;
              this.cA = localContext.getResources().getDrawable(2130850278);
              this.cB = localContext.getResources().getDrawable(2130850279);
              this.cA.setColorFilter(Color.parseColor(this.afK), PorterDuff.Mode.SRC_OVER);
              this.cB.setColorFilter(Color.parseColor(this.afL), PorterDuff.Mode.SRC_OVER);
              if (((this.cA instanceof GradientDrawable)) && ((this.cB instanceof GradientDrawable)))
              {
                ((GradientDrawable)this.cB).setCornerRadius(this.aPN);
                ((GradientDrawable)this.cA).setCornerRadius(this.aPN);
              }
              if (i != 0) {
                break label287;
              }
            }
            label287:
            for (Drawable localDrawable = this.cB;; localDrawable = this.cA)
            {
              localView.setBackgroundDrawable(localDrawable);
              this.mIndicatorContainer.addView(localView, localLayoutParams);
              i += 1;
              break;
              j = this.aPO;
              break label126;
            }
          }
        }
        i = 0;
        while (i < m)
        {
          this.mIndicatorContainer.getChildAt(i).setVisibility(0);
          i += 1;
        }
        i = m;
        while (i < k)
        {
          this.mIndicatorContainer.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
    }
  }
  
  private void aNs()
  {
    if ((this.alb) && (this.jdField_a_of_type_Ltx != null))
    {
      if (this.jdField_a_of_type_Lty.getDataCount() > 1)
      {
        this.jdField_a_of_type_Ltx.aNu();
        this.jdField_a_of_type_Ltx.rv(this.aPK);
        this.jdField_a_of_type_Ltx.rw(this.aPL);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ltx.stopLoop();
  }
  
  private void aNt()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    SideBarView localSideBarView;
    if (this.akX)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue != null) {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.getLayoutSize());
      }
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue != null)) {
        localLayoutParams.topMargin = (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.getLayoutSize() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.getLayoutSize() / 2);
      }
      if ((this.akX) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a() == null))
      {
        localSideBarView = new SideBarView(this.mContext.getContext());
        this.fd.addView(localSideBarView, localLayoutParams);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.setSideBarView(localSideBarView);
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a().setPath(this.afH);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a().setBgColor(this.afI);
      localSideBarView = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a();
      if (!this.akY) {
        break label212;
      }
    }
    label212:
    for (float f = 1.0F;; f = 0.0F)
    {
      localSideBarView.setAlpha(f);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a().setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a().setMinimumHeight(0);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.setOnStateChangeListener(new ltw(this));
      return;
    }
  }
  
  private void b(VafContext paramVafContext)
  {
    this.jdField_a_of_type_Lty = new lty(paramVafContext);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView = new ProteusRecycleView(paramVafContext.getContext());
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.setAdapter(this.jdField_a_of_type_Lty);
    this.jdField_a_of_type_Lty.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView);
    this.jdField_a_of_type_Lty.a(new ltr(this));
    Object localObject = new LinearLayoutManager(paramVafContext.getContext());
    if (this.isHorizontal) {
      ((LinearLayoutManager)localObject).setOrientation(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.addOnScrollListener(this.mScrollListener);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.addOnChildAttachStateChangeListener(new lts(this));
      this.fd = new RelativeLayout(paramVafContext.getContext());
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.fd.addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView, (ViewGroup.LayoutParams)localObject);
      this.mIndicatorContainer = new LinearLayout(paramVafContext.getContext());
      paramVafContext = new RelativeLayout.LayoutParams(-2, -2);
      paramVafContext.addRule(14);
      paramVafContext.addRule(12);
      this.mIndicatorContainer.setPadding(0, 0, 0, this.aPP);
      this.fd.addView(this.mIndicatorContainer, paramVafContext);
      lcc.a().b(new ltu(this));
      return;
      ((LinearLayoutManager)localObject).setOrientation(1);
    }
  }
  
  private void f(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {}
    do
    {
      return;
      String str = paramJSONArray.optString(0, "0");
      paramJSONArray = paramJSONArray.optJSONArray(1);
      this.akZ = "1".equals(str);
    } while (paramJSONArray == null);
    this.afK = paramJSONArray.optString(0, "#80FFFFFF");
    this.afL = paramJSONArray.optString(1, "#FF07D0B0");
  }
  
  private void g(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    String str = paramJSONArray.optString(0, "relative");
    double d1 = paramJSONArray.optDouble(1, 16.0D);
    double d2 = paramJSONArray.optDouble(2, 3.0D);
    double d3 = paramJSONArray.optDouble(3, 2.5D);
    double d4 = paramJSONArray.optDouble(4, 4.0D);
    double d5 = paramJSONArray.optDouble(5, 12.0D);
    if ("relative".equals(str))
    {
      this.aPM = Utils.rp2px(d1);
      this.mIndicatorHeight = Utils.rp2px(d2);
      this.aPN = Utils.rp2px(d3);
      this.aPO = Utils.rp2px(d4);
      this.aPP = Utils.rp2px(d5);
      return;
    }
    this.aPM = Utils.dp2px(d1);
    this.mIndicatorHeight = Utils.dp2px(d2);
    this.aPN = Utils.dp2px(d3);
    this.aPO = Utils.dp2px(d4);
    this.aPP = Utils.dp2px(d5);
  }
  
  public void a(ProteusRecycleView.b paramb)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView$b = paramb;
  }
  
  public void a(lty.c paramc)
  {
    this.jdField_a_of_type_Lty.a(paramc);
  }
  
  public void aNq()
  {
    if (this.jdField_a_of_type_Lty == null) {
      return;
    }
    aNr();
  }
  
  public int getComMeasuredHeight()
  {
    return this.fd.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.fd.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.fd;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.fd.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.fd.measure(paramInt1, paramInt2);
    SideBarView localSideBarView = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a();
    if ((localSideBarView != null) && (localSideBarView.getLayoutParams() != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localSideBarView.getLayoutParams();
      paramInt1 = this.fd.getMeasuredHeight();
      if (QLog.isColorLevel())
      {
        QLog.i(this.TAG, 2, "sideBarView, onComMeasure, height = " + this.fd.getMeasuredHeight());
        QLog.i(this.TAG, 2, "sideBarView, onComMeasure, width = " + this.fd.getMeasuredWidth());
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue == null) && (localLayoutParams.height != paramInt1))
      {
        localLayoutParams.height = paramInt1;
        localSideBarView.setLayoutParams(localLayoutParams);
        localSideBarView.setMinimumHeight(localLayoutParams.height);
      }
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue == null))
      {
        localLayoutParams.topMargin = (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.getLayoutSize() - paramInt1 / 2);
        localSideBarView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.fd.setBackgroundColor(this.mBackground);
    aNt();
    if ((this.aPJ == 1) && (this.jdField_a_of_type_Ltx == null))
    {
      this.jdField_a_of_type_Ltx = new ltx();
      this.jdField_a_of_type_Ltx.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView);
      this.jdField_a_of_type_Ltx.b(new ltv(this));
    }
    if (this.jdField_a_of_type_Lug == null)
    {
      this.jdField_a_of_type_Lug = new lug(this.isHorizontal, this.di[0], this.di[1], this.di[2], this.di[3]);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.addItemDecoration(this.jdField_a_of_type_Lug);
    }
    LinearLayout localLinearLayout = this.mIndicatorContainer;
    if (this.akZ) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      this.jdField_a_of_type_Lty.nH(this.ala);
      aNs();
      return;
    }
  }
  
  public void ru(int paramInt)
  {
    int j = this.mIndicatorContainer.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.mIndicatorContainer.getChildAt(i);
      if (i == paramInt) {}
      for (Drawable localDrawable = this.cB;; localDrawable = this.cA)
      {
        localView.setBackgroundDrawable(localDrawable);
        i += 1;
        break;
      }
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    int i = 1003;
    int j = 0;
    Object localObject1;
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramObject);
    case 1069: 
      if (!(paramObject instanceof List)) {
        break;
      }
    case 52: 
    case 1052: 
      try
      {
        List localList = (List)paramObject;
        this.jdField_a_of_type_Lty.cE(localList);
        if ((paramObject instanceof JSONArray)) {
          G(new RvPolymericContainer.6(this, (JSONArray)paramObject));
        }
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        try
        {
          if (!(paramObject instanceof JSONArray)) {
            return false;
          }
          paramObject = (JSONArray)paramObject;
          paramInt = j;
          if (paramObject.length() < 4) {
            return false;
          }
          while (paramInt < 4)
          {
            localObject1 = Utils.toInteger(Integer.valueOf(paramObject.getInt(paramInt)));
            if (localObject1 != null) {
              this.di[paramInt] = Utils.rp2px(((Integer)localObject1).intValue());
            }
            paramInt += 1;
          }
          return true;
        }
        catch (JSONException paramObject)
        {
          paramObject.printStackTrace();
        }
      }
    case 54: 
      if (!(paramObject instanceof JSONArray)) {
        return false;
      }
      for (;;)
      {
        try
        {
          paramObject = (JSONArray)paramObject;
          if ((paramObject.length() == 0) || (!(paramObject.get(0) instanceof JSONArray))) {
            break;
          }
          localObject1 = (JSONArray)paramObject.get(0);
          paramInt = 1;
          if (paramInt < paramObject.length())
          {
            Object localObject2 = paramObject.get(paramInt);
            if (!(localObject2 instanceof JSONArray)) {
              break label446;
            }
            localObject2 = (JSONArray)localObject2;
            i = 0;
            if ((i >= paramObject.length()) || (i >= ((JSONArray)localObject1).length())) {
              break label446;
            }
            if (((((JSONArray)localObject2).get(i) instanceof JSONObject)) && ((((JSONArray)localObject1).get(i) instanceof JSONObject)))
            {
              JSONObject localJSONObject1 = (JSONObject)((JSONArray)localObject2).get(i);
              JSONObject localJSONObject2 = (JSONObject)((JSONArray)localObject1).get(i);
              Iterator localIterator = localJSONObject1.keys();
              if (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                localJSONObject2.put(str, localJSONObject1.get(str));
                continue;
              }
            }
          }
          else
          {
            return true;
          }
        }
        catch (Exception paramObject)
        {
          QLog.e(this.TAG, 2, "setCellArray:remoteArray: ", paramObject);
        }
        i += 1;
        continue;
        G(new RvPolymericContainer.7(this, (JSONArray)localObject1));
        paramInt += 1;
      }
    case 1122: 
      if (!(paramObject instanceof JSONArray)) {
        return false;
      }
      f((JSONArray)paramObject);
      return true;
    case 1123: 
      if (!(paramObject instanceof JSONArray)) {
        return false;
      }
      g((JSONArray)paramObject);
      return true;
    case 1130: 
      this.ala = "1".equals(paramObject);
      return true;
    case 1133: 
      for (;;)
      {
        try
        {
          label446:
          paramObject = (JSONArray)paramObject;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue = new SizeValue();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.value = Double.valueOf(paramObject.getString(0)).doubleValue();
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
          if (!"relative".equals(paramObject.getString(0))) {
            continue;
          }
          ((SizeValue)localObject1).valueType = i;
        }
        catch (Exception paramObject)
        {
          QLog.e(this.TAG, 2, "setEdgeDragHeight:type: ", paramObject);
          continue;
        }
        return true;
        i = 1004;
      }
    }
    for (;;)
    {
      try
      {
        paramObject = (JSONArray)paramObject;
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue = new SizeValue();
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.value = Double.valueOf(paramObject.getString(0)).doubleValue();
        localObject1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
        if (!"relative".equals(paramObject.getString(0))) {
          continue;
        }
        ((SizeValue)localObject1).valueType = i;
      }
      catch (Exception paramObject)
      {
        QLog.e(this.TAG, 2, "setEdgeDragCenterY:type: ", paramObject);
        continue;
      }
      return true;
      i = 1004;
    }
    return false;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1048: 
      this.afJ = paramString;
      return true;
    case 1049: 
      if (String.valueOf(1).equals(paramString))
      {
        this.aPJ = 1;
        return true;
      }
      this.aPJ = 0;
      return true;
    case 1051: 
      this.akX = "1".equals(paramString);
      return true;
    case 1047: 
      this.akY = "1".equals(paramString);
      return true;
    case 1050: 
      this.akZ = "1".equals(paramString);
      return true;
    case 1129: 
      this.ala = true;
      this.alb = true;
      this.aPK = Integer.valueOf(paramString).intValue();
      return true;
    case 1131: 
      this.afI = paramString;
      return true;
    }
    this.afH = paramString;
    return true;
  }
  
  public void setModel(lie paramlie)
  {
    this.jdField_a_of_type_Lty.setModel(paramlie);
    aNq();
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new ltp(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltp
 * JD-Core Version:    0.7.0.1
 */