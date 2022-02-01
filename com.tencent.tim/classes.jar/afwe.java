import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.a;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFooterView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.TabLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class afwe
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private afte jdField_a_of_type_Afte;
  private afvl jdField_a_of_type_Afvl;
  private afwg jdField_a_of_type_Afwg;
  ExtendFriendCampusVerifyTipsView.a jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$a;
  private afth.a jdField_b_of_type_Afth$a;
  private afth jdField_b_of_type_Afth;
  private MiniAppRecommInfo jdField_b_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo;
  private afua c;
  private int cUh;
  private boolean cbs;
  private int csr = 0;
  private GdtAppReceiver d;
  private Activity mActivity;
  private List<afua> mList;
  private RecyclerView mRecyclerView;
  private int mType = 0;
  
  public afwe(afte paramafte, afwg paramafwg, afth.a parama, ExtendFriendCampusVerifyTipsView.a parama1, RecyclerView paramRecyclerView, Activity paramActivity, int paramInt, GdtAppReceiver paramGdtAppReceiver)
  {
    this.jdField_a_of_type_Afte = paramafte;
    this.mRecyclerView = paramRecyclerView;
    this.mActivity = paramActivity;
    this.mType = paramInt;
    this.mList = new ArrayList();
    this.c = new afua();
    this.c.mType = 1;
    this.jdField_a_of_type_Afwg = paramafwg;
    this.jdField_b_of_type_Afth$a = parama;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$a = parama1;
    this.cUh = 0;
    this.d = paramGdtAppReceiver;
  }
  
  public void ID(boolean paramBoolean)
  {
    this.cbs = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void Nv(int paramInt)
  {
    this.cUh = paramInt;
  }
  
  public void Nw(int paramInt)
  {
    this.csr = paramInt;
  }
  
  public afua a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mList != null)
    {
      int i = this.mList.size();
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < i) {
          localObject1 = (afua)this.mList.get(paramInt);
        }
      }
    }
    return localObject1;
  }
  
  public void a(int paramInt, afua paramafua)
  {
    this.mList.add(paramInt, paramafua);
  }
  
  public void a(afvl paramafvl)
  {
    this.jdField_a_of_type_Afvl = paramafvl;
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo)
  {
    int k = 1;
    int j = 0;
    if ((this.mList == null) || (paramMiniAppRecommInfo == null)) {
      return;
    }
    int i = 0;
    if (i < this.mList.size()) {
      if (((afua)this.mList.get(i) instanceof MiniAppRecommInfo)) {
        this.mList.remove(i);
      }
    }
    for (i = 1;; i = 0)
    {
      if (paramMiniAppRecommInfo.appInfoList.size() > 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo = paramMiniAppRecommInfo;
        label81:
        if (j >= getItemCount()) {
          break label139;
        }
        if (getItemViewType(j) == 0)
        {
          this.mList.add(j, paramMiniAppRecommInfo);
          i = k;
        }
      }
      label139:
      for (;;)
      {
        if (i == 0) {
          break label140;
        }
        notifyDataSetChanged();
        return;
        i += 1;
        break;
        j += 1;
        break label81;
        this.jdField_b_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo = null;
      }
      label140:
      break;
    }
  }
  
  public void addAll(List<afua> paramList)
  {
    this.mList.addAll(paramList);
    if (this.jdField_b_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo != null) {
      a(this.jdField_b_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo);
    }
  }
  
  public int af()
  {
    return this.mList.size();
  }
  
  public void b(aftg paramaftg)
  {
    if ((this.jdField_b_of_type_Afth != null) && (this.jdField_b_of_type_Afth.itemView != null)) {
      this.jdField_b_of_type_Afth.a(paramaftg);
    }
  }
  
  public void bx(int paramInt, boolean paramBoolean)
  {
    this.c.mFooterType = paramInt;
    if ((paramBoolean) && (!this.mList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public int cS(String paramString)
  {
    int j = -1;
    int i = j;
    if (this.mList != null)
    {
      i = j;
      if (this.mList.size() > 0)
      {
        j = -1;
        i = 0;
        while (i < this.mList.size())
        {
          if (paramString.equals(((afua)this.mList.get(i)).mUin)) {
            j = i;
          }
          i += 1;
        }
        i = j;
      }
    }
    return i;
  }
  
  public void clear()
  {
    this.mList.clear();
  }
  
  public int getItemCount()
  {
    if (this.cbs) {
      return this.mList.size() + 1;
    }
    if (this.mList.isEmpty()) {
      return 0;
    }
    return this.mList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.mList.size() == 0) {
      return 2;
    }
    if (paramInt < this.mList.size())
    {
      if ((this.mList.get(paramInt) instanceof MiniAppRecommInfo)) {
        return 5;
      }
      if ((this.mList.get(paramInt) instanceof aftf)) {
        return 6;
      }
      if ((this.mList.get(paramInt) instanceof aftl)) {
        return 7;
      }
      if (((afua)this.mList.get(paramInt)).mAlumbasicdata != null) {
        return 4;
      }
      return 0;
    }
    return 1;
  }
  
  public List<afua> getList()
  {
    return this.mList;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject1 = (aftm)paramViewHolder;
      Object localObject2 = (afua)this.mList.get(paramInt);
      if (paramInt == 0) {
        i = this.cUh;
      }
      ((aftm)localObject1).a((aftm)localObject1, (afua)localObject2, i);
      if ((this.jdField_a_of_type_Afwg != null) && (this.jdField_a_of_type_Afwg.DH() == paramInt) && (!((aftm)localObject1).b.isAnimating())) {
        ((aftm)localObject1).b.startAnimation();
      }
      while (this.jdField_a_of_type_Afvl != null)
      {
        this.jdField_a_of_type_Afvl.lO(((afua)localObject2).mUin);
        break;
        ((aftm)localObject1).b.stopAnimation();
      }
      localObject1 = (afto)paramViewHolder;
      ((afto)localObject1).a((afto)localObject1, this.c);
      continue;
      localObject1 = (afsz)paramViewHolder;
      ((afsz)localObject1).a((afsz)localObject1, null, this.csr);
      continue;
      localObject1 = (aftx)paramViewHolder;
      localObject2 = (MiniAppRecommInfo)this.mList.get(paramInt);
      i = j;
      if (paramInt == 0) {
        i = this.cUh;
      }
      ((aftx)localObject1).a((MiniAppRecommInfo)localObject2, i);
      continue;
      localObject1 = (afta)paramViewHolder;
      localObject2 = (afua)this.mList.get(paramInt);
      i = k;
      if (paramInt == 0) {
        i = this.cUh;
      }
      ((afta)localObject1).a((afta)localObject1, (afua)localObject2, i);
      continue;
      localObject1 = (afth)paramViewHolder;
      localObject2 = (afua)this.mList.get(paramInt);
      i = m;
      if (paramInt == 0) {
        i = this.cUh;
      }
      ((afth)localObject1).a((afua)localObject2, i);
      continue;
      localObject1 = (aftk)paramViewHolder;
      localObject2 = (afua)this.mList.get(paramInt);
      i = n;
      if (paramInt == 0) {
        i = this.cUh;
      }
      ((aftk)localObject1).a((afua)localObject2, i);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    Object localObject = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    case 3: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
      do
      {
        return null;
        paramViewGroup = new ExtendFriendFeedView(this.mActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new aftm(paramViewGroup, this.jdField_a_of_type_Afwg, this.jdField_a_of_type_Afte, this.mActivity);
        paramViewGroup = new ExtendFriendFooterView(this.mActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new afto(paramViewGroup, this.jdField_a_of_type_Afwg);
        return new afsz(((LayoutInflater)localObject).inflate(2131561323, paramViewGroup, false), this.mRecyclerView, this.cUh, this.jdField_a_of_type_Afwg, this.mType);
        paramViewGroup = new ExtendFriendFeedView(this.mActivity);
        paramViewGroup.removeAllViews();
        localObject = new awnr(this.mActivity, 2131563327, 3, 1, this.d);
      } while (((awnr)localObject).getView() == null);
      paramViewGroup.addView(((awnr)localObject).getView(), localLayoutParams);
      return new afta(paramViewGroup, this.mActivity, this.jdField_a_of_type_Afwg, (awnr)localObject);
    case 5: 
      return new aftx(((LayoutInflater)localObject).inflate(2131559590, paramViewGroup, false), this.mActivity);
    case 6: 
      paramViewGroup = new TabLayout(this.mActivity);
      paramViewGroup.setLayoutParams(localLayoutParams);
      paramViewGroup = new afth(paramViewGroup, this.jdField_b_of_type_Afth$a);
      if (this.jdField_b_of_type_Afth != null) {
        this.jdField_b_of_type_Afth.destroy();
      }
      this.jdField_b_of_type_Afth = ((afth)paramViewGroup);
      return paramViewGroup;
    }
    paramViewGroup = new ExtendFriendCampusVerifyTipsView(this.mActivity);
    paramViewGroup.setLayoutParams(localLayoutParams);
    return new aftk(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$a);
  }
  
  public void onDestroy()
  {
    if (this.jdField_b_of_type_Afth != null) {
      this.jdField_b_of_type_Afth.destroy();
    }
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((paramViewHolder instanceof afth)) {
      ((afth)paramViewHolder).destroy();
    }
  }
  
  public void remove(int paramInt)
  {
    this.mList.remove(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwe
 * JD-Core Version:    0.7.0.1
 */