import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.List;

public class axoz
  extends BaseAdapter
{
  MusicProviderView a;
  private Context mContext;
  List<MusicItemInfo> mData;
  int mGridWidth;
  int mItemHeight;
  
  public axoz(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.mContext = paramContext;
    this.a = paramMusicProviderView;
  }
  
  private void a(axoz.a parama)
  {
    int j = 2130845437;
    MusicItemInfo localMusicItemInfo2 = parama.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    int k = localMusicItemInfo2.mType;
    MusicItemInfo localMusicItemInfo1 = ((axro)axov.a().c(8)).c();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)axov.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.equals((MusicItemInfo)localObject);
    if ((this.a.bjK == 5) && (this.a.i != null) && (localMusicItemInfo2.mType == 2) && (localObject != null) && (((MusicItemInfo)localObject).equals(this.a.i))) {
      bool = true;
    }
    for (;;)
    {
      if ((k == 1) || (k == 5))
      {
        parama.mNameView.setVisibility(0);
        parama.aht.setVisibility(8);
        parama.ahu.setVisibility(8);
        parama.IB.setVisibility(8);
        parama.mNameView.setText(localMusicItemInfo2.mMusicName);
        parama.aht.setText(localMusicItemInfo2.mSingername);
        if ((bool) && (!localMusicItemInfo2.isDownloading()))
        {
          i = 2130845417;
          if (localMusicItemInfo2.isMyMusicInfo())
          {
            i = 2130845433;
            parama.ahu.setText(acfp.m(2131708604));
            parama.ahu.setVisibility(0);
            parama.IA.setImageResource(i);
            parama.IA.setVisibility(0);
            label251:
            parama.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
            localObject = axxj.a(localMusicItemInfo2);
            parama.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a((axxj)localObject);
            if ((!localMusicItemInfo2.isDownloading()) || (((axxj)localObject).bJ != 2)) {
              break label342;
            }
            parama.Iz.setVisibility(8);
          }
        }
        for (;;)
        {
          a(parama, localMusicItemInfo2);
          return;
          parama.ahu.setVisibility(8);
          break;
          parama.IA.setVisibility(8);
          parama.ahu.setVisibility(8);
          break label251;
          label342:
          if (!localMusicItemInfo2.isFileExist()) {
            parama.Iz.setVisibility(0);
          } else {
            parama.Iz.setVisibility(8);
          }
        }
      }
      parama.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(null);
      parama.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      parama.IB.setVisibility(8);
      parama.mNameView.setVisibility(8);
      parama.aht.setVisibility(8);
      parama.ahu.setVisibility(0);
      parama.IA.setVisibility(8);
      localObject = acfp.m(2131708610);
      int i = 2130845434;
      if (k == 3)
      {
        localObject = acfp.m(2131708607);
        j = 2130845435;
        i = 2130845436;
        if (!bool) {
          break label582;
        }
        parama.Hi.setImageResource(i);
      }
      for (;;)
      {
        parama.Iz.setVisibility(8);
        parama.ahu.setText((CharSequence)localObject);
        return;
        if (k == 6)
        {
          localObject = acfp.m(2131708606);
          break;
        }
        if (k == 8)
        {
          localObject = acfp.m(2131708612);
          break;
        }
        if (k == 4)
        {
          localObject = acfp.m(2131708605);
          j = 2130845430;
          i = 2130845431;
          break;
        }
        if (k != 10) {
          break;
        }
        localObject = acfp.m(2131708611);
        j = 2130845438;
        i = 2130845438;
        parama.IB.setVisibility(0);
        break;
        label582:
        parama.Hi.setImageResource(j);
      }
    }
  }
  
  public void a(axoz.a parama, MusicItemInfo paramMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramMusicItemInfo.mAlbumUrl))
    {
      parama.Hi.setImageResource(2130845432);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = wja.dp2px(80.0F, parama.Hi.getResources());
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mFailedDrawable = this.mContext.getResources().getDrawable(2130845432);
    localURLDrawableOptions.mLoadingDrawable = this.mContext.getResources().getDrawable(2130845432);
    paramMusicItemInfo = URLDrawable.getDrawable(paramMusicItemInfo.mAlbumUrl, localURLDrawableOptions);
    if (paramMusicItemInfo.getStatus() == 2) {
      paramMusicItemInfo.restartDownload();
    }
    paramMusicItemInfo.setDecodeHandler(aqbn.v);
    parama.Hi.setImageDrawable(paramMusicItemInfo);
  }
  
  public View cL()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    Object localObject1 = new RelativeLayout(this.mContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = aqnm.dpToPx(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(this.mContext);
    ((ImageView)localObject2).setId(2131372101);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.mContext);
    ((TextView)localObject2).setId(2131372102);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), aqnm.dpToPx(10.0F));
    ((TextView)localObject2).setMaxLines(4);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, Color.parseColor("#80000000"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = aqnm.dpToPx(5.0F);
    localLayoutParams.topMargin = aqnm.dpToPx(8.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(this.mContext);
    ((TextView)localObject2).setId(2131372100);
    ((TextView)localObject2).setTextColor(Color.parseColor("#9fffffff"));
    ((TextView)localObject2).setTextSize(2, 9.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    i = aqnm.dpToPx(5.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.bottomMargin = aqnm.dpToPx(4.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(this.mContext);
    ((ImageView)localObject2).setId(2131372103);
    ((ImageView)localObject2).setImageResource(2130845417);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.mContext);
    ((TextView)localObject2).setId(2131374689);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = aqnm.dpToPx(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.mContext);
    ((QIMCommonLoadingView)localObject2).setId(2131372119);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.mContext);
    ((ImageView)localObject1).setId(2131372093);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130846849);
    i = aqnm.dpToPx(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.mContext);
    ((ImageView)localObject1).setId(2131382330);
    ((ImageView)localObject1).setImageResource(2130846856);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.mGridWidth <= 0) && (paramViewGroup != null))
    {
      this.mGridWidth = paramViewGroup.getMeasuredWidth();
      this.mItemHeight = ((int)((this.mGridWidth - MusicProviderPagerAdapter.dyo * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
    }
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)getItem(paramInt);
    axoz.a locala;
    if (paramView == null)
    {
      locala = new axoz.a();
      paramView = cL();
      locala.mNameView = ((TextView)paramView.findViewById(2131372102));
      locala.aht = ((TextView)paramView.findViewById(2131372100));
      locala.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131372119));
      locala.Hi = ((ImageView)paramView.findViewById(2131372101));
      locala.ahu = ((TextView)paramView.findViewById(2131374689));
      locala.IA = ((ImageView)paramView.findViewById(2131372103));
      locala.Iz = ((ImageView)paramView.findViewById(2131372093));
      locala.IB = ((ImageView)paramView.findViewById(2131382330));
      paramView.setTag(locala);
    }
    for (;;)
    {
      locala.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
      locala.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
      locala.mPosition = paramInt;
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null)
      {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -1);
        paramView.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams1.height = this.mItemHeight;
      a(locala);
      if (localMusicItemInfo.isWsBanner()) {
        rpw.aq(localMusicItemInfo);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (axoz.a)paramView.getTag();
    }
  }
  
  public void jx(View paramView)
  {
    paramView = (axoz.a)paramView.getTag();
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void setData(List<MusicItemInfo> paramList)
  {
    this.mData = paramList;
  }
  
  public class a
  {
    ImageView Hi;
    ImageView IA;
    ImageView IB;
    ImageView Iz;
    MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    QIMCommonLoadingView jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView;
    TextView aht;
    TextView ahu;
    TextView mNameView;
    int mPosition;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axoz
 * JD-Core Version:    0.7.0.1
 */