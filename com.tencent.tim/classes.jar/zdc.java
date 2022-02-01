import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class zdc
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private Context J;
  private TextView MA;
  private afhj jdField_a_of_type_Afhj;
  private afhl jdField_a_of_type_Afhl;
  private EmoticonGroupStoreFragment jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment;
  private zdc.c jdField_a_of_type_Zdc$c = new zde(this);
  private ImgPreviewAdapter b;
  public boolean bqM;
  private int ccZ;
  private int cda = -1;
  private Button eA;
  private Button eB;
  private Map<String, String> ik = new HashMap();
  private Map<Integer, Integer> il = new HashMap();
  private Map<Integer, String> im = new HashMap();
  private Map<Integer, List<EmoticonFromGroupEntity>> in = new TreeMap();
  private ViewPager j;
  private QQAppInterface mApp;
  private boolean mClickable;
  private Map<String, List<EmoticonFromGroupEntity>> mData;
  private LayoutInflater mLayoutInflater;
  private ImageView uY;
  private View yw;
  
  public zdc(QQAppInterface paramQQAppInterface, EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment, int paramInt, View paramView, ViewPager paramViewPager, Button paramButton)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment = paramEmoticonGroupStoreFragment;
    this.J = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.getActivity();
    this.ccZ = paramInt;
    this.yw = paramView;
    this.eA = ((Button)this.yw.findViewById(2131363883));
    this.uY = ((ImageView)this.yw.findViewById(2131369009));
    this.MA = ((TextView)this.yw.findViewById(2131381077));
    this.j = paramViewPager;
    this.j.setPageMargin(2);
    this.mLayoutInflater = LayoutInflater.from(this.J);
    this.b = new ImgPreviewAdapter(this.mApp, this.J, this.j);
    this.j.setAdapter(this.b);
    this.j.setOnPageChangeListener(new zdd(this));
    this.eB = paramButton;
    this.jdField_a_of_type_Afhj = ((afhj)paramQQAppInterface.getManager(259));
    this.jdField_a_of_type_Afhl = ((aqrc)paramQQAppInterface.getManager(235)).c;
    this.jdField_a_of_type_Afhl.cZA();
  }
  
  private void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    Object localObject1 = null;
    if (1 == paramEmoticonFromGroupEntity.fromType)
    {
      localObject1 = this.mApp.getFaceBitmap(4, paramEmoticonFromGroupEntity.troopUin, (byte)2, false, (byte)1, 0);
      paramEmoticonFromGroupEntity = aqgv.a(this.mApp, paramEmoticonFromGroupEntity.troopUin, true);
    }
    for (;;)
    {
      this.uY.setImageBitmap((Bitmap)localObject1);
      this.MA.setText(paramEmoticonFromGroupEntity);
      return;
      if (3000 == paramEmoticonFromGroupEntity.fromType)
      {
        localObject1 = this.mApp.getFaceBitmap(101, paramEmoticonFromGroupEntity.troopUin, (byte)1, false, (byte)1, 0);
        paramEmoticonFromGroupEntity = aqgv.b(this.mApp, this.J, paramEmoticonFromGroupEntity.troopUin);
      }
      else
      {
        Object localObject2 = null;
        paramEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  private void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt1, int paramInt2)
  {
    AbstractGifImage.resumeAll();
    a(paramEmoticonFromGroupEntity);
    int i;
    int k;
    if (-1 != paramEmoticonFromGroupEntity.status)
    {
      if (paramEmoticonFromGroupEntity.status == 0)
      {
        this.eA.setText(acfp.m(2131709640));
        this.eA.setTextColor(Color.parseColor("#FFBBBBBB"));
        this.eA.setBackgroundDrawable(this.J.getResources().getDrawable(2130845276));
        this.eA.setEnabled(false);
      }
      if (!this.in.containsKey(Integer.valueOf(paramInt2))) {
        break label263;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.titleRoot != this.yw.getParent())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.titleRoot.addView(this.yw);
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.L(false);
      }
      i = 0;
      k = 0;
      label135:
      if (k >= paramInt2) {
        break label251;
      }
      if (!this.in.containsKey(Integer.valueOf(k))) {
        break label307;
      }
      i = ((List)this.in.get(Integer.valueOf(k))).size() + i;
    }
    label263:
    label307:
    for (;;)
    {
      k += 1;
      break label135;
      this.eA.setText(acfp.m(2131709641));
      this.eA.setTextColor(Color.parseColor("#FFFFFFFF"));
      this.eA.setBackgroundDrawable(this.J.getResources().getDrawable(2130845275));
      this.eA.setEnabled(true);
      break;
      label251:
      this.j.setCurrentItem(i + paramInt1, false);
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  private void b(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity.status == 0)
    {
      this.eA.setText(acfp.m(2131709647));
      this.eA.setTextColor(Color.parseColor("#FFBBBBBB"));
      this.eA.setBackgroundDrawable(this.J.getResources().getDrawable(2130845276));
      this.eA.setEnabled(false);
      return;
    }
    this.eA.setText(acfp.m(2131709645));
    this.eA.setTextColor(Color.parseColor("#FFFFFFFF"));
    this.eA.setBackgroundDrawable(this.J.getResources().getDrawable(2130845275));
    this.eA.setEnabled(true);
  }
  
  private void cop()
  {
    Iterator localIterator = this.mData.entrySet().iterator();
    int n = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      this.im.put(Integer.valueOf(n), str);
      this.il.put(Integer.valueOf(n), Integer.valueOf(0));
      localObject = (List)((Map.Entry)localObject).getValue();
      int i1 = ((List)localObject).size();
      int i2 = (int)Math.ceil(i1 / 3.0D);
      int m = 0;
      int k = 0;
      int i = n + 1;
      n = i;
      if (m < i2)
      {
        ArrayList localArrayList = new ArrayList();
        n = 0;
        for (;;)
        {
          if ((k + n >= i1) || (n >= 3))
          {
            this.im.put(Integer.valueOf(i), str);
            this.in.put(Integer.valueOf(i), localArrayList);
            this.il.put(Integer.valueOf(i), Integer.valueOf(1));
            m += 1;
            i += 1;
            k = n + k;
            break;
          }
          localArrayList.add(((List)localObject).get(k + n));
          n += 1;
        }
      }
    }
  }
  
  private void gc(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      paramInt2 = -1;
    }
    Object localObject;
    for (;;)
    {
      localObject = (EmoticonFromGroupEntity)((List)this.in.get(Integer.valueOf(paramInt1))).get(paramInt2);
      if (!this.mClickable) {
        break label385;
      }
      if (-1 == ((EmoticonFromGroupEntity)localObject).status) {
        break label235;
      }
      paramInt1 = ((EmoticonFromGroupEntity)localObject).status;
      if (((EmoticonFromGroupEntity)localObject).status == 0) {
        break label178;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.tQ.remove(localObject);
      ((EmoticonFromGroupEntity)localObject).status = -1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.tQ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)((Iterator)localObject).next();
        if (localEmoticonFromGroupEntity.status > paramInt1) {
          localEmoticonFromGroupEntity.status -= 1;
        }
      }
      paramInt2 = 0;
      continue;
      paramInt2 = 1;
      continue;
      paramInt2 = 2;
    }
    notifyDataSetChanged();
    label178:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.tQ.size() > 0)
    {
      this.eB.setTextColor(Color.parseColor("#FFFFFFFF"));
      this.eB.setBackgroundDrawable(this.J.getResources().getDrawable(2130845275));
      this.eB.setEnabled(true);
      return;
      label235:
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.tQ.size();
      if (this.jdField_a_of_type_Afhj.cQU <= paramInt1)
      {
        FavEmosmManageActivity.dd(this.J);
      }
      else if (20 > this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.tQ.size())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.tQ.add(localObject);
        ((EmoticonFromGroupEntity)localObject).status = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.tQ.size();
        notifyDataSetChanged();
      }
      else
      {
        QQToast.a(this.J, "单次最多收藏20个表情哦~", 0).show(2131299627);
      }
    }
    this.eB.setTextColor(Color.parseColor("#FFBFBFBF"));
    this.eB.setBackgroundDrawable(this.J.getResources().getDrawable(2130845276));
    this.eB.setEnabled(false);
    return;
    label385:
    a((EmoticonFromGroupEntity)localObject, paramInt2, paramInt1);
  }
  
  public void a(Map<String, List<EmoticonFromGroupEntity>> paramMap, List<EmoticonFromGroupEntity> paramList)
  {
    this.mData = paramMap;
    this.in.clear();
    this.im.clear();
    this.il.clear();
    cop();
    this.ik.clear();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      this.ik.put(str, this.jdField_a_of_type_Afhl.i(str, ((List)localObject).size(), "  "));
    }
    notifyDataSetChanged();
    this.b.setData(paramList);
    this.b.notifyDataSetChanged();
  }
  
  public boolean aF(boolean paramBoolean)
  {
    boolean bool = this.mClickable;
    this.mClickable = paramBoolean;
    return bool;
  }
  
  public String cS(int paramInt)
  {
    String str = (String)this.im.get(Integer.valueOf(paramInt));
    return (String)this.ik.get(str);
  }
  
  public int getItemCount()
  {
    int i = 0;
    if (this.mData != null)
    {
      int k = this.mData.size();
      Iterator localIterator = this.mData.entrySet().iterator();
      for (i = 0; localIterator.hasNext(); i = (int)Math.ceil(((List)((Map.Entry)localIterator.next()).getValue()).size() / 3.0D) + i) {}
      i = k + i + 1;
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 2;
    }
    return ((Integer)this.il.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof zdc.d))
    {
      zdc.d locald = (zdc.d)paramViewHolder;
      List localList = (List)this.in.get(Integer.valueOf(paramInt));
      int k = localList.size();
      int i = 0;
      if (i < 3)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)locald.p[i].getParent();
        if (i < k)
        {
          localRelativeLayout.setVisibility(0);
          locald.p[i].setImageDrawable(this.jdField_a_of_type_Afhl.a((EmoticonFromGroupEntity)localList.get(i), 65537, this.ccZ, null));
          this.cda = ((EmoticonFromGroupEntity)((List)this.in.get(Integer.valueOf(paramInt))).get(i)).status;
          if (this.cda == 0)
          {
            ((zdc.d)paramViewHolder).a[i].setVisibility(4);
            ((zdc.d)paramViewHolder).q[i].setVisibility(0);
            paramViewHolder.itemView.setClickable(false);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.bqM)
          {
            ((zdc.d)paramViewHolder).q[i].setVisibility(4);
            if (this.cda > 0)
            {
              ((zdc.d)paramViewHolder).a[i].setVisibility(0);
              ((zdc.d)paramViewHolder).a[i].setCheckedNumber(this.cda);
            }
            else
            {
              ((zdc.d)paramViewHolder).a[i].setChecked(false);
              ((zdc.d)paramViewHolder).a[i].setVisibility(0);
            }
          }
          else
          {
            ((zdc.d)paramViewHolder).a[i].setVisibility(4);
            ((zdc.d)paramViewHolder).q[i].setVisibility(4);
            continue;
            localRelativeLayout.setVisibility(4);
          }
        }
      }
      paramViewHolder.itemView.setTag(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if ((paramViewHolder instanceof zdc.a)) {
        ((zdc.a)paramViewHolder).MB.setText((CharSequence)this.ik.get(this.im.get(Integer.valueOf(paramInt))));
      } else if ((paramViewHolder instanceof zdc.b)) {
        ((zdc.b)paramViewHolder).MC.setText("仅保留最新的300个聊天表情，\n更多表情请在消息记录中查找哦～");
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GroupEmoUI.PicSelectAdapter", 2, "view type: " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new zdc.a(this.mLayoutInflater.inflate(2131562100, paramViewGroup, false));
    case 1: 
      paramViewGroup = this.mLayoutInflater.inflate(2131562101, paramViewGroup, false);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.getLayoutParams();
      localLayoutParams.height = this.ccZ;
      paramViewGroup.setLayoutParams(localLayoutParams);
      paramViewGroup = new zdc.d(paramViewGroup);
      paramViewGroup.a(this.jdField_a_of_type_Zdc$c);
      return paramViewGroup;
    }
    return new zdc.b(this.mLayoutInflater.inflate(2131562104, paramViewGroup, false));
  }
  
  public static class a
    extends RecyclerView.ViewHolder
  {
    TextView MB;
    
    a(View paramView)
    {
      super();
      this.MB = ((TextView)paramView.findViewById(2131381103));
    }
  }
  
  public static class b
    extends RecyclerView.ViewHolder
  {
    TextView MC;
    
    b(View paramView)
    {
      super();
      this.MC = ((TextView)paramView.findViewById(2131381079));
    }
  }
  
  public static abstract interface c
  {
    public abstract void gd(int paramInt1, int paramInt2);
  }
  
  public static class d
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private zdc.c a;
    public NumberCheckBox[] a;
    public NumberCheckBox b;
    public NumberCheckBox c;
    public NumberCheckBox d;
    public ImageView[] p;
    public ImageView[] q;
    public ImageView uZ;
    public ImageView va;
    public ImageView vb;
    public ImageView vc;
    public ImageView vd;
    public ImageView vf;
    
    public d(View paramView)
    {
      super();
      this.uZ = ((ImageView)paramView.findViewById(2131369036));
      this.b = ((NumberCheckBox)paramView.findViewById(2131364588));
      this.va = ((ImageView)paramView.findViewById(2131369068));
      this.vb = ((ImageView)paramView.findViewById(2131369037));
      this.c = ((NumberCheckBox)paramView.findViewById(2131364589));
      this.vc = ((ImageView)paramView.findViewById(2131369069));
      this.vd = ((ImageView)paramView.findViewById(2131369038));
      this.d = ((NumberCheckBox)paramView.findViewById(2131364590));
      this.vf = ((ImageView)paramView.findViewById(2131369070));
      this.p = new ImageView[] { this.uZ, this.vb, this.vd };
      paramView = this.p;
      int j = paramView.length;
      int i = 0;
      while (i < j)
      {
        paramView[i].setOnClickListener(this);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox = new NumberCheckBox[] { this.b, this.c, this.d };
      this.q = new ImageView[] { this.va, this.vc, this.vf };
    }
    
    void a(zdc.c paramc)
    {
      this.jdField_a_of_type_Zdc$c = paramc;
    }
    
    public void onClick(View paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.i("picOnClick.1", 2, "v.getId: " + paramView.getId() + " itemView.getTag: " + this.itemView.getTag());
      }
      if (this.jdField_a_of_type_Zdc$c != null) {
        this.jdField_a_of_type_Zdc$c.gd(((Integer)this.itemView.getTag()).intValue(), paramView.getId());
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdc
 * JD-Core Version:    0.7.0.1
 */