import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper.1;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendLabelFlowLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class afnd
  extends aflk
  implements afhd.c, View.OnClickListener, AbsListView.e
{
  protected static String bEc;
  protected static boolean bZv;
  protected static boolean bZw;
  protected static int cSn = 0;
  protected View BQ;
  protected TextView Ry;
  protected afll a;
  protected ExtendFriendLabelFlowLayout a;
  protected ListView b;
  protected boolean bZx;
  protected ViewGroup ea;
  protected ViewGroup eb;
  protected View mFooterView;
  protected View mHeaderView;
  protected int mLastScrollState = 0;
  protected int mLoadingStatus = 0;
  protected List<String> yV;
  
  public afnd()
  {
    super(null);
  }
  
  public afnd(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private void daO()
  {
    if (getPageType() == 1) {
      if (ajB()) {
        afnu.cN("0X800AE31", 0);
      }
    }
    while (getPageType() != 2)
    {
      return;
      afnu.cN("0X800AE22", 0);
      return;
    }
    reportEvent("0X800AE38");
  }
  
  public int[] C()
  {
    return new int[] { 8, 4, 5 };
  }
  
  public void HT(String paramString)
  {
    bEc = paramString;
  }
  
  public void HZ(boolean paramBoolean)
  {
    bZv = paramBoolean;
  }
  
  public void Id(String paramString)
  {
    bZw = false;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Afll == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "startSearch.");
    }
    HT(paramString);
    this.jdField_a_of_type_Afll.setData(new ArrayList());
    daK();
    cZu();
  }
  
  public void MK(int paramInt)
  {
    if ((QLog.isColorLevel()) && (cSn != paramInt)) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "setSearchContainerVisibility visibility= " + paramInt + " mLoadingStatus: " + this.mLoadingStatus);
    }
    cSn = paramInt;
    if ((this.eb != null) && (this.ea != null))
    {
      if (TextUtils.isEmpty(ut()))
      {
        this.ea.setVisibility(8);
        this.eb.setVisibility(paramInt);
      }
    }
    else {
      return;
    }
    this.eb.setVisibility(8);
    this.ea.setVisibility(paramInt);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, afhd.b paramb, afhd.c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "pushEmotionSearchTask ");
    }
    paramQQAppInterface = (afhd)paramQQAppInterface.getManager(367);
    paramQQAppInterface.cZt();
    paramQQAppInterface.a(paramc);
    paramQQAppInterface.a(paramb);
  }
  
  public void a(EmotionPanelListView paramEmotionPanelListView, afll paramafll, int paramInt)
  {
    if ((paramEmotionPanelListView != null) && (paramInt == 14))
    {
      b(paramEmotionPanelListView, paramafll);
      paramafll = getHeaderView();
      if ((paramafll.getParent() == null) && (paramEmotionPanelListView.findHeaderViewPosition(paramafll) == -1)) {
        paramEmotionPanelListView.addHeaderView(paramafll);
      }
      paramafll = bU();
      if (paramafll.getParent() == null) {
        paramEmotionPanelListView.addFooterView(paramafll);
      }
    }
  }
  
  protected void aSa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "start onLoadMore");
    }
    if (getPageType() == 2) {
      reportEvent("0X800AE37");
    }
    afhd.a(getApp()).loadMore();
  }
  
  protected boolean ajA()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if ("EmoticonPanelHotPicSearchHelper".equals(getTag()))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.BQ.getLayoutParams();
      if (localLayoutParams == null) {
        return true;
      }
      i = localLayoutParams.topMargin;
      if ((this.yV == null) || (this.yV.isEmpty()) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.getVisibility() != 0)) {
        break label106;
      }
    }
    label106:
    for (localLayoutParams.topMargin = (aqnm.dip2px(60.0F) + this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.getHeight());; localLayoutParams.topMargin = aqnm.dip2px(60.0F))
    {
      if (localLayoutParams.topMargin != i) {
        this.BQ.setLayoutParams(localLayoutParams);
      }
      return false;
    }
  }
  
  public boolean ajB()
  {
    return !aqmr.isEmpty(ut());
  }
  
  public void b(afhd.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "OnSearchCallBack ");
    }
    if ((this.jdField_a_of_type_Afll == null) || (this.b == null))
    {
      this.bZx = false;
      return;
    }
    if (parama == null)
    {
      this.bZx = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "OnSearchCallBack result： " + parama.getResult());
    }
    if ((parama.getResult() == -101) || (parama.getResult() == -103))
    {
      this.bZx = false;
      return;
    }
    if (getPageType() == 1)
    {
      if (!ajB()) {
        break label143;
      }
      afnu.cN("0X800AE2C", 0);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new EmoticonPanelHotPicSearchHelper.1(this, parama));
      return;
      label143:
      afnu.cN("0X800AE21", 0);
    }
  }
  
  public void b(EmotionPanelListView paramEmotionPanelListView)
  {
    if (this.mHeaderView != null) {
      paramEmotionPanelListView.removeHeaderView(this.mHeaderView);
    }
    if (this.mFooterView != null) {
      paramEmotionPanelListView.removeFooterView(this.mFooterView);
    }
  }
  
  protected void b(ListView paramListView, afll paramafll)
  {
    this.b = paramListView;
    this.jdField_a_of_type_Afll = paramafll;
  }
  
  protected View bU()
  {
    if (this.mFooterView == null)
    {
      this.mFooterView = View.inflate(getContext(), 2131558664, null);
      this.mFooterView.setBackgroundColor(0);
      this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, aqnm.dip2px(74.0F)));
    }
    daH();
    return this.mFooterView;
  }
  
  protected void baw()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController == null) {
      return;
    }
    if ((getPageType() == 1) && (!TextUtils.isEmpty(ut())))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.daq();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setLeftScrollDisEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setRightScrollDisEnable(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.dax();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Afnp.MN(EmoticonPanelController.cSe);
  }
  
  public void c(afhd.a parama)
  {
    int i;
    if (parama.getResult() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, "OnSearchCallBack success isHasMore: " + parama.isHasMore());
      }
      Object localObject = parama.getItemList();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if ((ajB()) && (getPageType() == 1)) {
          afnu.cN("0X800AE2B", 0);
        }
        setLoadingStatus(8);
        this.jdField_a_of_type_Afll.setData(new ArrayList());
        daF();
        daG();
        daH();
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmotionSearchItem localEmotionSearchItem = (EmotionSearchItem)((Iterator)localObject).next();
        localArrayList.add(new afpm(getPageType(), localArrayList.size() + 1, ut(), localEmotionSearchItem));
      }
      if ((this.mLoadingStatus == 0) || (this.mLoadingStatus == 5)) {
        kJ();
      }
      if (parama.isHasMore())
      {
        i = 1;
        setLoadingStatus(i);
        daG();
        daH();
        this.jdField_a_of_type_Afll.setData(localArrayList);
        daF();
      }
    }
    for (;;)
    {
      this.bZx = false;
      return;
      i = 3;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, "OnSearchCallBack fail");
      }
      d(parama);
    }
  }
  
  protected void cN(String paramString, int paramInt)
  {
    afnu.cN(paramString, paramInt);
  }
  
  public void cZu()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController == null) {
      return;
    }
    ((afmw)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(1)).cZu();
  }
  
  public void cZv()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController == null) {
      return;
    }
    ((afmw)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(1)).cZv();
  }
  
  public void cZw()
  {
    bEc = null;
  }
  
  protected void d(afhd.a parama)
  {
    if ((this.mLoadingStatus == 0) || (this.mLoadingStatus == 5)) {
      setLoadingStatus(4);
    }
    for (;;)
    {
      daG();
      daF();
      daH();
      return;
      if ((parama.getResult() == -102) || (parama.getResult() == -100)) {
        setLoadingStatus(7);
      } else if (parama.getResult() == -104) {
        setLoadingStatus(3);
      } else {
        setLoadingStatus(2);
      }
    }
  }
  
  protected void daE()
  {
    afhd.a(getApp()).cZt();
  }
  
  protected void daF()
  {
    if ((this.b == null) || (this.BQ == null)) {}
    TextView localTextView;
    View localView;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelHotPicSearchHelper", 2, "updateLoadingView.");
        }
      } while (ajA());
      localTextView = (TextView)this.BQ.findViewById(2131366328);
      localView = this.BQ.findViewById(2131366339);
      this.BQ.setVisibility(0);
      if ((this.mLoadingStatus != 4) || ((aqnm.dip2px(XPanelContainer.OZ()) >= XPanelContainer.aLe) && (!"RichTextPanelEmoticonSearchLayoutHelper".equals(getTag())))) {
        break;
      }
      localView.setVisibility(8);
      localTextView.setText(2131690140);
      localTextView.setOnClickListener(this);
      if (getPageType() == 2)
      {
        reportEvent("0X800AE39");
        return;
      }
    } while (getPageType() != 1);
    if (ajB())
    {
      afnu.cN("0X800AE32", 0);
      return;
    }
    afnu.cN("0X800AE23", 0);
    return;
    if (this.mLoadingStatus == 5)
    {
      localView.setVisibility(0);
      localTextView.setText(2131690135);
      daO();
      return;
    }
    if (this.mLoadingStatus == 8)
    {
      localView.setVisibility(8);
      localTextView.setText(2131690138);
      return;
    }
    this.BQ.setVisibility(8);
  }
  
  protected void daG()
  {
    if (this.mHeaderView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "notifyHeaderViewChange loadingStatus:" + this.mLoadingStatus);
    }
    if (TextUtils.isEmpty(ut()))
    {
      this.ea.setVisibility(8);
      this.eb.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(0);
    }
    for (;;)
    {
      MK(cSn);
      return;
      this.Ry.setText(ut());
      this.ea.setVisibility(0);
      this.eb.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.mBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.mBaseChatPie.a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.mBaseChatPie.a.clearFocus();
      }
    }
  }
  
  protected void daH()
  {
    if (this.mFooterView == null) {}
    TextView localTextView1;
    View localView;
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelHotPicSearchHelper", 2, "notifyFooterViewChange.");
        }
        localTextView1 = (TextView)this.mFooterView.findViewById(2131368661);
        localTextView1.setTextSize(12.0F);
        localView = this.mFooterView.findViewById(2131368660);
        TextView localTextView2 = (TextView)this.mFooterView.findViewById(2131370815);
        localTextView2.setTextSize(12.0F);
        localTextView1.setOnClickListener(this);
        localLayoutParams = this.mFooterView.getLayoutParams();
        int i = dip2px(74);
        if (localLayoutParams.height != i)
        {
          localLayoutParams.height = i;
          this.mFooterView.setLayoutParams(localLayoutParams);
        }
        if ((this.mLoadingStatus == 1) || (this.mLoadingStatus == 0))
        {
          localView.setVisibility(0);
          localTextView2.setText(2131690135);
          localTextView1.setVisibility(4);
          daO();
          return;
        }
        if (this.mLoadingStatus != 7) {
          break;
        }
        localTextView1.setVisibility(0);
        localTextView1.setText(2131690139);
        localView.setVisibility(4);
      } while (getPageType() != 2);
      reportEvent("0X800AE39");
      return;
      if ((this.mLoadingStatus != 2) && ((this.mLoadingStatus != 4) || (dip2px(XPanelContainer.OZ()) < XPanelContainer.aLe) || (!"EmoticonPanelHotPicSearchHelper".equals(getTag())))) {
        break;
      }
      localTextView1.setVisibility(0);
      localTextView1.setText(2131690140);
      localView.setVisibility(4);
    } while (getPageType() != 2);
    reportEvent("0X800AE39");
    return;
    localTextView1.setVisibility(8);
    localView.setVisibility(8);
    localLayoutParams.height = -2;
    this.mFooterView.setLayoutParams(localLayoutParams);
  }
  
  public void daI()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "start loadPicData word is null: " + TextUtils.isEmpty(ut()) + " sPrepareSearch: " + bZw);
    }
    if (TextUtils.isEmpty(ut())) {
      daJ();
    }
    do
    {
      return;
      if (!bZw)
      {
        daM();
        daK();
        return;
      }
    } while (this.mLoadingStatus == 5);
    setLoadingStatus(5);
    daG();
    daH();
    daF();
  }
  
  protected void daJ()
  {
    setLoadingStatus(0);
    bZv = false;
    bZw = false;
    daL();
    cZw();
    daH();
    daG();
    daF();
    baw();
    afhd.b localb = new afhd.b(0);
    a(getApp(), localb, this);
  }
  
  public void daK()
  {
    if (TextUtils.isEmpty(ut())) {
      return;
    }
    if ((ajB()) && (getPageType() == 1)) {
      afnu.cN("0X800AE2A", 0);
    }
    bZv = false;
    bZw = false;
    daL();
    setLoadingStatus(5);
    daH();
    daG();
    baw();
    daF();
    afhd.b localb = new afhd.b(1, ut());
    a(getApp(), localb, this);
  }
  
  protected void daL()
  {
    if ((this.jdField_a_of_type_Afll instanceof afoa)) {
      ((afoa)this.jdField_a_of_type_Afll).daL();
    }
  }
  
  protected void daM()
  {
    if (bZv)
    {
      bZv = false;
      cZu();
    }
  }
  
  public void daN()
  {
    bZw = true;
    setLoadingStatus(0);
  }
  
  protected int dip2px(int paramInt)
  {
    return aqnm.dip2px(paramInt);
  }
  
  public QQAppInterface getApp()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController == null) {
      return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.app;
  }
  
  public Context getContext()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController == null) {
      return BaseApplicationImpl.sApplication;
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.context;
  }
  
  @NonNull
  public View getHeaderView()
  {
    if (this.mHeaderView != null) {
      return this.mHeaderView;
    }
    this.mHeaderView = View.inflate(getContext(), 2131559286, null);
    gu(this.mHeaderView);
    Object localObject = aejr.a();
    if (localObject != null)
    {
      localObject = ((aejr.a)localObject).yV;
      this.yV = ((List)localObject);
      if ((localObject != null) && (!this.yV.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(new afnd.a(getContext(), this.yV));
        if (this.yV != null) {
          break label165;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelHotPicSearchHelper", 4, "emoticonTags is null. ");
        }
      }
    }
    for (;;)
    {
      return this.mHeaderView;
      this.yV = Arrays.asList(getContext().getResources().getStringArray(2130968579));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(new afnd.a(getContext(), this.yV));
      break;
      label165:
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 4, "emoticonTags size: " + this.yV.size());
      }
    }
  }
  
  public int getPageType()
  {
    return 1;
  }
  
  public String getTag()
  {
    return "EmoticonPanelHotPicSearchHelper";
  }
  
  protected void gu(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(2131367332));
    this.ea = ((ViewGroup)paramView.findViewById(2131370771));
    this.Ry = ((TextView)paramView.findViewById(2131380914));
    ImageView localImageView = (ImageView)paramView.findViewById(2131369888);
    Button localButton = (Button)paramView.findViewById(2131363800);
    this.eb = ((ViewGroup)paramView.findViewById(2131367173));
    paramView.findViewById(2131377526).setBackgroundDrawable(s(18));
    this.eb.setBackgroundDrawable(s(18));
    TextView localTextView = this.Ry;
    if (ThemeUtil.isNowThemeIsNight(getApp(), false, null)) {}
    for (paramView = "#B0B3BF";; paramView = "#03081A")
    {
      localTextView.setTextColor(Color.parseColor(paramView));
      localImageView.setOnClickListener(this);
      this.eb.setOnClickListener(this);
      localButton.setOnClickListener(this);
      this.Ry.setOnClickListener(this);
      MK(cSn);
      return;
    }
  }
  
  protected void iF(String paramString)
  {
    anot.a(getApp(), "dc00898", "", "", paramString, paramString, 0, 0, "2", "", "", "");
  }
  
  protected void kJ()
  {
    if (this.b == null) {
      return;
    }
    this.b.setOnScrollListener(new afne(this));
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
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController != null)
      {
        cZw();
        Rect localRect = new Rect();
        this.ea.getGlobalVisibleRect(localRect);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.mBaseChatPie.a(true, localRect.bottom, true, null, 0);
        continue;
        cZw();
        cZv();
        daJ();
        cN("0X800AE30", 0);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController != null)
        {
          cN("0X800AE2F", 0);
          localRect = new Rect();
          this.eb.getGlobalVisibleRect(localRect);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.mBaseChatPie.a(true, localRect.bottom, true, null, this.eb.getWidth());
          iF("0X800AE1E");
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController != null)
          {
            localRect = new Rect();
            this.Ry.getGlobalVisibleRect(localRect);
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.mBaseChatPie.a(true, localRect.bottom, false, ut(), this.Ry.getWidth());
            continue;
            if (this.mLoadingStatus == 4)
            {
              daI();
              if (getPageType() == 2) {
                reportEvent("0X800AE3A");
              }
            }
            else
            {
              setLoadingStatus(1);
              daH();
              aSa();
              continue;
              daI();
              if (getPageType() == 2) {
                reportEvent("0X800AE3A");
              } else if (getPageType() == 1) {
                if (ajB()) {
                  afnu.cN("0X800AE33", 0);
                } else {
                  afnu.cN("0X800AE24", 0);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "onDestory.");
    }
    daL();
    cZw();
    daE();
    cSn = 0;
    bZw = false;
    this.bZx = false;
    this.jdField_a_of_type_Afll = null;
    this.b = null;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    while ((paramInt1 + paramInt2 < paramInt3) || (this.mLoadingStatus != 1) || (this.bZx)) {
      return;
    }
    this.bZx = true;
    if (((paramAbsListView instanceof EmotionPanelListView)) && (this.mLastScrollState == 2)) {
      ((EmotionPanelListView)paramAbsListView).abordFling();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    aSa();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onShow()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "onShow ");
    }
    if ((this.mLoadingStatus == 6) && (this.b != null) && (this.jdField_a_of_type_Afll != null))
    {
      if (!TextUtils.isEmpty(ut())) {
        break label53;
      }
      daJ();
    }
    label53:
    boolean bool;
    do
    {
      return;
      bool = bZv;
      daM();
    } while (bool);
    daK();
  }
  
  protected void reportEvent(String paramString)
  {
    anot.a(getApp(), "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  protected Drawable s(int paramInt)
  {
    if (ThemeUtil.isNowThemeIsNight(getApp(), false, null)) {}
    for (String str = "#1C1C1C";; str = "#F5F6FA") {
      return aqnm.h(Color.parseColor(str), aqnm.dip2px(paramInt));
    }
  }
  
  public void setEmptyView(View paramView)
  {
    this.BQ = paramView;
  }
  
  protected void setLoadingStatus(int paramInt)
  {
    this.mLoadingStatus = paramInt;
  }
  
  public String ut()
  {
    return bEc;
  }
  
  public void yQ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "onHide.");
    }
    this.mLoadingStatus = 6;
  }
  
  class a
    extends BaseAdapter
  {
    private Context mContext;
    private List<String> mDatas;
    
    public a(List<String> paramList)
    {
      Object localObject;
      this.mDatas = localObject;
      this.mContext = paramList;
    }
    
    public int getCount()
    {
      return this.mDatas.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.mDatas.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = View.inflate(this.mContext, 2131559287, null);
      }
      for (;;)
      {
        Button localButton = (Button)paramView.findViewById(2131364016);
        localButton.setText((CharSequence)this.mDatas.get(paramInt));
        localButton.setContentDescription((CharSequence)this.mDatas.get(paramInt));
        localButton.setBackgroundDrawable(afnd.this.s(12));
        if (ThemeUtil.isNowThemeIsNight(afnd.this.getApp(), false, null)) {
          localButton.setTextColor(Color.parseColor("#B0B3BF"));
        }
        for (;;)
        {
          localButton.setOnClickListener(new afnf(this, localButton));
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localButton.setTextColor(Color.parseColor("#03081A"));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnd
 * JD-Core Version:    0.7.0.1
 */