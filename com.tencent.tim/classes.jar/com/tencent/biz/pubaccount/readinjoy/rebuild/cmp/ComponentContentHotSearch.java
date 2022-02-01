package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aenl;
import aenm;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aoop;
import aqcx;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kbp;
import kxm;
import lbz;
import lie;
import lwk;
import lwm.a;
import mbb;
import mhi;
import mhj;
import ndi;
import org.json.JSONObject;

public class ComponentContentHotSearch
  extends RelativeLayout
  implements lwk
{
  public static final String TAG = ComponentContentHotSearch.class.getSimpleName();
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch$a;
  private ComponentNotIntrest jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest;
  private MeasureGridView jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView;
  private ArticleInfo b;
  private lie d;
  private ndi e;
  private RelativeLayout i;
  private URLImageView v;
  
  public ComponentContentHotSearch(Context paramContext, ndi paramndi)
  {
    super(paramContext);
    this.e = paramndi;
    init(paramContext);
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      this.d = ((lie)paramObject);
      this.b = this.d.a();
      if (this.b != null) {}
    }
    else
    {
      return;
    }
    paramObject = this.b.hotWordInfo;
    if ((paramObject != null) && (paramObject.iN != null) && (paramObject.iN.size() > 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch$a.setData(paramObject.iN);
      paramObject = aenm.a();
      if ((paramObject == null) || (TextUtils.isEmpty(paramObject.bzU))) {
        break label191;
      }
    }
    label191:
    for (paramObject = paramObject.bzU;; paramObject = "https://pub.idqqimg.com/pc/misc/files/20180903/eddc885537fc4606a66c93a06854511b.png")
    {
      Drawable localDrawable = aoop.TRANSPARENT;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mRequestWidth = this.v.getWidth();
      localURLDrawableOptions.mRequestHeight = this.v.getHeight();
      paramObject = URLDrawable.getDrawable(paramObject, localURLDrawableOptions);
      this.v.setImageDrawable(paramObject);
      if ((paramObject.getStatus() == 1) || (paramObject.getStatus() == 0)) {
        break;
      }
      paramObject.restartDownload();
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, "bindData hotWordInfo is null or hotWordItems is null ");
      return;
    }
  }
  
  public void a(lwm.a parama)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(parama);
    }
  }
  
  public void cG(View paramView)
  {
    this.i = ((RelativeLayout)paramView.findViewById(2131368652));
    this.v = ((URLImageView)paramView.findViewById(2131379813));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131372477));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView = ((MeasureGridView)paramView.findViewById(2131368651));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch$a = new a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch$a);
    this.i.setOnClickListener(new mbb(this));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560300, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
  
  public class a
    extends BaseAdapter
  {
    private List<mhj> mDatas;
    
    protected a() {}
    
    public mhj a(int paramInt)
    {
      return (mhj)this.mDatas.get(paramInt);
    }
    
    public int getCount()
    {
      if (this.mDatas != null) {
        return this.mDatas.size();
      }
      return 0;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      if (0 == 0)
      {
        localObject1 = new ComponentContentHotSearch.b(ComponentContentHotSearch.this);
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560398, null);
        ((ComponentContentHotSearch.b)localObject1).ql = ((TextView)paramView.findViewById(2131369140));
        ((ComponentContentHotSearch.b)localObject1).titleText = ((TextView)paramView.findViewById(2131379862));
        paramView.setOnClickListener((View.OnClickListener)localObject1);
        paramView.setTag(localObject1);
      }
      for (;;)
      {
        mhj localmhj = a(paramInt);
        if (!TextUtils.isEmpty(localmhj.hotWord)) {
          ((ComponentContentHotSearch.b)localObject1).titleText.setText(localmhj.hotWord);
        }
        ((ComponentContentHotSearch.b)localObject1).ql.setText(paramInt + 1 + "");
        Object localObject2 = ((ComponentContentHotSearch.b)localObject1).ql;
        int i;
        if (!TextUtils.isEmpty(localmhj.agU))
        {
          i = Color.parseColor(localmhj.agU);
          label159:
          ((TextView)localObject2).setTextColor(i);
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setShape(0);
          ((GradientDrawable)localObject2).setCornerRadius(aqcx.dip2px(ComponentContentHotSearch.this.getContext(), 2.0F));
          if (TextUtils.isEmpty(localmhj.indexBgColor)) {
            break label422;
          }
          i = Color.parseColor(localmhj.indexBgColor);
          ((GradientDrawable)localObject2).setColor(i);
          ((ComponentContentHotSearch.b)localObject1).ql.setBackgroundDrawable((Drawable)localObject2);
          ((ComponentContentHotSearch.b)localObject1).a = localmhj;
          if (!localmhj.isReported)
          {
            localmhj.isReported = true;
            localObject1 = kxm.a(localmhj.hotWord, ComponentContentHotSearch.a(ComponentContentHotSearch.this).innerUniqueID, paramInt + 1);
          }
        }
        try
        {
          kbp.a(null, "CliOper", "", "", "0X80096DC", "0X80096DC", 0, 0, "", "", "", ((JSONObject)localObject1).toString(), false);
          localObject1 = new ArrayList();
          localObject2 = new ReportInfo();
          ((ReportInfo)localObject2).mUin = kxm.getLongAccountUin();
          ((ReportInfo)localObject2).mOperation = 52;
          ((ReportInfo)localObject2).mInnerId = ComponentContentHotSearch.a(ComponentContentHotSearch.this).innerUniqueID;
          ((ReportInfo)localObject2).mHotWord = localmhj.hotWord;
          ((List)localObject1).add(localObject2);
          lbz.a().cb((List)localObject1);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localObject1 = (ComponentContentHotSearch.b)paramView.getTag();
          continue;
          i = Color.parseColor("#8C000000");
          break label159;
          label422:
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e(ComponentContentHotSearch.TAG, 1, "getView, e = " + localException);
          }
        }
      }
    }
    
    public void setData(List<mhj> paramList)
    {
      this.mDatas = paramList;
      notifyDataSetChanged();
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    mhj jdField_a_of_type_Mhj;
    TextView ql;
    TextView titleText;
    
    protected b() {}
    
    public void onClick(View paramView)
    {
      Object localObject = new Intent(this.titleText.getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Mhj.jumpUrl);
      this.titleText.getContext().startActivity((Intent)localObject);
      localObject = kxm.a(this.jdField_a_of_type_Mhj.hotWord, ComponentContentHotSearch.a(ComponentContentHotSearch.this).innerUniqueID, ComponentContentHotSearch.a(ComponentContentHotSearch.this).hotWordInfo.iN.indexOf(this.jdField_a_of_type_Mhj) + 1);
      try
      {
        kbp.a(null, "CliOper", "", "", "0X80096DD", "0X80096DD", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
        kxm.a(ComponentContentHotSearch.this.getContext(), ComponentContentHotSearch.a(ComponentContentHotSearch.this), ComponentContentHotSearch.a(ComponentContentHotSearch.this), (int)ComponentContentHotSearch.a(ComponentContentHotSearch.this).mChannelID);
        localObject = new ArrayList();
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = kxm.getLongAccountUin();
        localReportInfo.mOperation = 53;
        localReportInfo.mInnerId = ComponentContentHotSearch.a(ComponentContentHotSearch.this).innerUniqueID;
        localReportInfo.mHotWord = this.jdField_a_of_type_Mhj.hotWord;
        ((List)localObject).add(localReportInfo);
        lbz.a().cb((List)localObject);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e(ComponentContentHotSearch.TAG, 1, "onClick, e = " + localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch
 * JD-Core Version:    0.7.0.1
 */