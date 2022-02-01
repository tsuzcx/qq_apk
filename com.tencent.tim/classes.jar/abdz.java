import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class abdz
  extends abdw
  implements View.OnClickListener
{
  private LinkedHashMap<String, List<PhoneContact>> D = new LinkedHashMap();
  public abdz.c a;
  boolean aOc = false;
  private int[] ad = new int[0];
  public IndexView b;
  int cmy = 0;
  int cmz = 0;
  PhoneContact d = null;
  private acff f;
  private String[] k = new String[0];
  private List<PhoneContact> kO = new ArrayList();
  private QQAppInterface mApp;
  private Context mContext;
  public List<PhoneContact> vG = new ArrayList();
  private List<PhoneContact> vQ = new ArrayList();
  
  public abdz(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<PhoneContact> paramList)
  {
    super(paramContext, paramQQAppInterface, paramXListView, true);
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.f = ((acff)paramQQAppInterface.getManager(51));
    this.cmy = paramContext.getResources().getDimensionPixelOffset(2131298589);
    this.cmz = paramContext.getResources().getDimensionPixelOffset(2131298590);
    cS(paramList);
  }
  
  public static abdz.b a(List<PhoneContact> paramList, ArrayList<PhoneContact> paramArrayList, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    abdz.b localb = new abdz.b();
    localb.vQ = ((List)localObject);
    label52:
    label53:
    PhoneContact localPhoneContact;
    if (paramArrayList != null)
    {
      paramList = (List)paramArrayList.clone();
      Iterator localIterator = ((List)localObject).iterator();
      break label193;
      if (!localIterator.hasNext()) {
        break label307;
      }
      localPhoneContact = (PhoneContact)localIterator.next();
      if (!TextUtils.isEmpty(localPhoneContact.pinyinFirst)) {
        break label285;
      }
      paramArrayList = "#";
      label89:
      i = paramArrayList.charAt(0);
      if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
        break label301;
      }
    }
    label285:
    label301:
    for (paramArrayList = paramArrayList.toUpperCase();; paramArrayList = "#")
    {
      if (localb.D.get(paramArrayList) == null) {
        localb.D.put(paramArrayList, new ArrayList());
      }
      ((List)localb.D.get(paramArrayList)).add(localPhoneContact);
      if ((paramList == null) || (!paramBoolean)) {
        break label53;
      }
      paramArrayList = paramList.iterator();
      label193:
      if (!paramArrayList.hasNext()) {
        break label53;
      }
      if (!TextUtils.equals(((PhoneContact)paramArrayList.next()).unifiedCode, localPhoneContact.unifiedCode)) {
        break label52;
      }
      if (localb.D.get("★") == null) {
        localb.D.put("★", new ArrayList());
      }
      ((List)localb.D.get("★")).add(localPhoneContact);
      break label53;
      paramList = null;
      break;
      paramArrayList = String.valueOf(localPhoneContact.pinyinFirst.charAt(0));
      break label89;
    }
    label307:
    if (paramList != null)
    {
      localb.kO = paramList;
      if (!paramBoolean)
      {
        if (localb.D.get("★") == null) {
          localb.D.put("★", new ArrayList());
        }
        ((List)localb.D.get("★")).addAll(paramList);
      }
    }
    paramArrayList = localb.D;
    localb.D = new LinkedHashMap();
    for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
      if (paramArrayList.get(String.valueOf(c)) != null) {
        localb.D.put(String.valueOf(c), paramArrayList.get(String.valueOf(c)));
      }
    }
    if (paramArrayList.get("#") != null) {
      localb.D.put("#", paramArrayList.get("#"));
    }
    if ((paramList != null) && ((((List)localObject).size() > 10) || (!paramBoolean)) && (paramArrayList.get("★") != null)) {
      localb.D.put("★", paramList);
    }
    paramArrayList.clear();
    localb.ad = new int[localb.D.keySet().size()];
    localb.k = new String[localb.ad.length];
    paramList = new ArrayList(localb.D.keySet());
    Collections.sort(paramList, new abea());
    paramArrayList = paramList.iterator();
    if (localb.ad.length == 0) {
      return localb;
    }
    localb.ad[0] = 0;
    int i = 1;
    while (i < localb.ad.length)
    {
      localObject = localb.ad;
      int j = localObject[i];
      int m = localb.ad[(i - 1)];
      localObject[i] = (((List)localb.D.get(paramArrayList.next())).size() + m + 1 + j);
      i += 1;
    }
    paramList = paramList.iterator();
    i = 0;
    while (paramList.hasNext())
    {
      localb.k[i] = ((String)paramList.next());
      i += 1;
    }
    return localb;
  }
  
  private boolean a(PhoneContact paramPhoneContact)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.vG.size())
      {
        PhoneContact localPhoneContact = (PhoneContact)this.vG.get(i);
        if (TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void Dl(boolean paramBoolean)
  {
    this.aOc = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int ag()
  {
    if (this.k.length > 0) {
      return 2131559496;
    }
    return 0;
  }
  
  public void b(abdz.b paramb)
  {
    this.vQ = paramb.vQ;
    this.ad = paramb.ad;
    this.D = paramb.D;
    this.k = paramb.k;
    this.kO = paramb.kO;
  }
  
  public void b(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.ad, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if ((paramInt < this.k.length) && (paramInt >= 0)) {
      ((TextView)paramView).setText(this.k[paramInt]);
    }
  }
  
  public void cS(List<PhoneContact> paramList)
  {
    b(a(paramList, null, true));
  }
  
  public void d(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    int i = 0;
    if (i < this.vG.size())
    {
      PhoneContact localPhoneContact = (PhoneContact)this.vG.get(i);
      if (!TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {}
    }
    for (;;)
    {
      if (paramBoolean) {
        if (i == -1)
        {
          this.vG.add(paramPhoneContact);
          notifyDataSetChanged();
        }
      }
      while (i == -1)
      {
        return;
        i += 1;
        break;
      }
      this.vG.remove(i);
      notifyDataSetChanged();
      return;
      i = -1;
    }
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
  }
  
  public int getCount()
  {
    if (this.ad.length == 0) {
      return 0;
    }
    int i = this.ad[(this.ad.length - 1)];
    return ((List)this.D.get(this.k[(this.k.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.ad, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (PhoneContact)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.ad, paramInt);
    Object localObject2;
    Object localObject1;
    if (paramView == null)
    {
      localObject2 = new abdz.a();
      Object localObject3 = LayoutInflater.from(this.mContext).inflate(2131561278, null);
      ((abdz.a)localObject2).Pl = ((TextView)((View)localObject3).findViewById(2131372384));
      ((abdz.a)localObject2).pQ = ((ImageView)((View)localObject3).findViewById(2131361802));
      ((abdz.a)localObject2).nickname = ((TextView)((View)localObject3).findViewById(2131377214));
      ((abdz.a)localObject2).Pm = ((TextView)((View)localObject3).findViewById(2131378586));
      ((abdz.a)localObject2).er = ((Button)((View)localObject3).findViewById(2131377201));
      ((abdz.a)localObject2).LF = ((TextView)((View)localObject3).findViewById(2131377211));
      ((abdz.a)localObject2).mCheckBox = ((CheckBox)((View)localObject3).findViewById(2131364585));
      ((abdz.a)localObject2).Gn = ((TextView)((View)localObject3).findViewById(2131380761));
      ((abdz.a)localObject2).An = ((View)localObject3).findViewById(2131374872);
      ((View)localObject3).setBackgroundDrawable(null);
      ((View)localObject3).setTag(localObject2);
      paramView = (View)localObject2;
      localObject1 = localObject3;
      if ((((abdz.a)localObject2).pQ instanceof ThemeImageView))
      {
        ((ThemeImageView)((abdz.a)localObject2).pQ).setSupportMaskView(false);
        localObject1 = localObject3;
        paramView = (View)localObject2;
      }
      if ((this.b == null) || (this.b.getVisibility() != 0)) {
        break label779;
      }
      ((View)localObject1).findViewById(2131377207).setPadding(0, 0, this.cmy, 0);
      label265:
      if (i >= 0) {
        break label1072;
      }
      i = -(i + 1) - 1;
      localObject2 = (PhoneContact)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
      paramView.e = ((PhoneContact)localObject2);
      if ((this.kO.isEmpty()) || ("★".equals(this.k[i])) || (!((PhoneContact)localObject2).isNewRecommend)) {
        break label800;
      }
      ysa.C((View)localObject1, true);
      ysa.D(paramView.An, true);
      label372:
      localObject3 = new StringBuilder(256);
      if (TextUtils.isEmpty(((PhoneContact)localObject2).name)) {
        break label817;
      }
      paramView.Pl.setVisibility(0);
      paramView.Pl.setText(((PhoneContact)localObject2).name);
      if (AppSetting.enableTalkBack)
      {
        aqcl.Q(paramView.Pl, false);
        ((StringBuilder)localObject3).append(((PhoneContact)localObject2).name);
      }
      label440:
      paramView.nickname.setVisibility(8);
      if (((PhoneContact)localObject2).samFriend <= 0) {
        break label829;
      }
      paramView.Pm.setVisibility(0);
      Object localObject4 = String.format(this.mContext.getResources().getString(2131692075), new Object[] { Integer.valueOf(((PhoneContact)localObject2).samFriend) });
      paramView.Pm.setText((CharSequence)localObject4);
      paramView.Pm.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      if (AppSetting.enableTalkBack) {
        ((StringBuilder)localObject3).append(",").append((String)localObject4);
      }
      label538:
      if ((TextUtils.isEmpty(((PhoneContact)localObject2).uin)) || (((PhoneContact)localObject2).uin.equals("0"))) {
        break label841;
      }
      paramView.er.setVisibility(8);
      paramView.LF.setVisibility(0);
      paramView.LF.setText(acfp.m(2131704371));
      if (this.aOc)
      {
        paramView.An.setEnabled(false);
        paramView.mCheckBox.setEnabled(false);
        paramView.mCheckBox.setChecked(false);
      }
      if (AppSetting.enableTalkBack) {
        paramView.LF.setContentDescription(acfp.m(2131704366));
      }
      label643:
      localObject4 = paramView.mCheckBox;
      if (!this.aOc) {
        break label1065;
      }
      i = 0;
      label659:
      ((CheckBox)localObject4).setVisibility(i);
      if (AppSetting.enableTalkBack) {
        ((View)localObject1).setContentDescription(((StringBuilder)localObject3).toString());
      }
      paramView.Gn.setVisibility(8);
      paramView.An.setVisibility(0);
      paramView.uin = ((PhoneContact)localObject2).unifiedCode;
      paramView.pQ.setImageBitmap(a(((PhoneContact)localObject2).unifiedCode, 11, (byte)0));
      paramView.An.setOnClickListener(this);
      paramView.An.setTag(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = (abdz.a)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      label779:
      ((View)localObject1).findViewById(2131377207).setPadding(0, 0, this.cmz, 0);
      break label265;
      label800:
      ysa.C((View)localObject1, false);
      ysa.D(paramView.An, false);
      break label372;
      label817:
      paramView.Pl.setVisibility(8);
      break label440;
      label829:
      paramView.Pm.setVisibility(8);
      break label538;
      label841:
      if (this.f.w(((PhoneContact)localObject2).unifiedCode, true))
      {
        paramView.er.setVisibility(8);
        paramView.LF.setVisibility(0);
        paramView.LF.setText(acfp.m(2131704369));
        if (this.aOc)
        {
          paramView.An.setEnabled(false);
          paramView.mCheckBox.setEnabled(false);
          paramView.mCheckBox.setChecked(false);
        }
        if (!AppSetting.enableTalkBack) {
          break label643;
        }
        paramView.LF.setContentDescription(acfp.m(2131704375));
        break label643;
      }
      if (this.aOc)
      {
        paramView.er.setVisibility(8);
        paramView.mCheckBox.setEnabled(true);
        paramView.mCheckBox.setChecked(a((PhoneContact)localObject2));
        paramView.mCheckBox.setTag(paramView);
      }
      for (;;)
      {
        paramView.An.setEnabled(true);
        paramView.LF.setVisibility(8);
        break;
        paramView.er.setVisibility(0);
        paramView.er.setText(acfp.m(2131721053));
        paramView.er.setTag(localObject2);
        paramView.er.setOnClickListener(this);
        if (AppSetting.enableTalkBack) {
          paramView.er.setContentDescription(acfp.m(2131721053));
        }
      }
      label1065:
      i = 8;
      break label659;
      label1072:
      paramView.An.setTag(null);
      paramView.An.setOnClickListener(null);
      paramView.An.setVisibility(8);
      paramView.Gn.setVisibility(0);
      paramView.Gn.setText(String.valueOf(this.k[i]));
    }
  }
  
  public int m(String paramString)
  {
    int i;
    if (this.k != null)
    {
      i = 0;
      if (i >= this.k.length) {
        break label53;
      }
      if (!this.k[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.ad[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 == null) {}
    boolean bool1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.mContext instanceof ContactBindedActivity)) {
        ((ContactBindedActivity)this.mContext).bLY();
      }
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131374872: 
        if (!this.aOc) {
          break label744;
        }
        localObject1 = (abdz.a)localObject1;
        boolean bool2 = a(((abdz.a)localObject1).e);
        localObject2 = ((abdz.a)localObject1).e;
        if (bool2) {
          break label732;
        }
        bool1 = true;
        label111:
        d((PhoneContact)localObject2, bool1);
        if (this.jdField_a_of_type_Abdz$c != null)
        {
          localObject2 = this.jdField_a_of_type_Abdz$c;
          localObject1 = ((abdz.a)localObject1).e;
          if (bool2) {
            break label738;
          }
          bool1 = true;
          label147:
          ((abdz.c)localObject2).a((PhoneContact)localObject1, bool1);
        }
        break;
      }
    }
    Object localObject2 = (PhoneContact)localObject1;
    localObject1 = (ajdo)this.mApp.getManager(11);
    int j;
    if (((Activity)this.mContext).getIntent().getBooleanExtra("from_babyq", false)) {
      j = 1;
    }
    for (int i = 3084;; i = 3006)
    {
      label268:
      label311:
      ContactBindedActivity localContactBindedActivity;
      if (!((ajdo)localObject1).Uv()) {
        if (this.kO.contains(localObject2))
        {
          anot.a(this.mApp, "dc00898", "", "", "0X80077CD", "0X80077CD", 1, 0, "", "", "", "");
          anot.a(this.mApp, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
          j = 16;
          i = 3006;
          ((PhoneContact)localObject2).isNewRecommend = false;
          if ((this.mContext instanceof ContactBindedActivity))
          {
            localContactBindedActivity = (ContactBindedActivity)this.mContext;
            if (!TextUtils.isEmpty(((PhoneContact)localObject2).pinyinFirst)) {
              break label712;
            }
          }
        }
      }
      label712:
      for (localObject1 = "#";; localObject1 = String.valueOf(((PhoneContact)localObject2).pinyinFirst.charAt(0)).toUpperCase())
      {
        localObject1 = (List)this.D.get(localObject1);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localContactBindedActivity.bFY = ((List)localObject1).indexOf(localObject2);
          if (localContactBindedActivity.bFY != -1) {
            localContactBindedActivity.a = ((PhoneContact)localObject2);
          }
        }
        localObject1 = AddFriendLogicActivity.a(this.mContext, 2, ((PhoneContact)localObject2).unifiedCode, null, i, j, ((PhoneContact)localObject2).name, null, null, acfp.m(2131704372), null);
        this.mContext.startActivity((Intent)localObject1);
        anot.a(this.mApp, "CliOper", "", "", "0X8006A75", "0X8006A75", 0, 0, "", "", "", "");
        notifyDataSetChanged();
        break;
        anot.a(this.mApp, "dc00898", "", "", "0X80077CD", "0X80077CD", 2, 0, "", "", "", "");
        break label268;
        if (this.kO.isEmpty())
        {
          anot.a(this.mApp, "dc00898", "", "", "0X80077D0", "0X80077D0", 0, 0, "", "", "", "");
          break label311;
        }
        if (this.kO.contains(localObject2)) {
          anot.a(this.mApp, "dc00898", "", "", "0X80077D3", "0X80077D3", 1, 0, "", "", "", "");
        }
        for (;;)
        {
          anot.a(this.mApp, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
          break;
          anot.a(this.mApp, "dc00898", "", "", "0X80077D3", "0X80077D3", 2, 0, "", "", "", "");
        }
      }
      label732:
      bool1 = false;
      break label111;
      label738:
      bool1 = false;
      break label147;
      label744:
      this.d = ((abdz.a)localObject1).e;
      if (this.d != null)
      {
        this.d.isNewRecommend = false;
        localObject2 = (PhoneContactManagerImp)this.mApp.getManager(11);
        if ((TextUtils.isEmpty(this.d.uin)) || ("0".equals(this.d.uin))) {
          break label899;
        }
        localObject1 = new ProfileActivity.AllInOne(this.d.uin, 30);
        ((ProfileActivity.AllInOne)localObject1).contactName = this.d.name;
        label844:
        ((ProfileActivity.AllInOne)localObject1).nickname = this.d.name;
        if ((!((PhoneContactManagerImp)localObject2).Uv()) || (!this.kO.isEmpty())) {
          break label956;
        }
        ((ProfileActivity.AllInOne)localObject1).bJa = 104;
      }
      for (;;)
      {
        ProfileActivity.b(this.mContext, (ProfileActivity.AllInOne)localObject1);
        notifyDataSetChanged();
        break;
        label899:
        if (((PhoneContactManagerImp)localObject2).Uv())
        {
          localObject1 = new ProfileActivity.AllInOne(this.d.unifiedCode, 34);
          break label844;
        }
        localObject1 = new ProfileActivity.AllInOne(this.d.unifiedCode, 29);
        ((ProfileActivity.AllInOne)localObject1).subSourceId = 16;
        break label844;
        label956:
        if (this.kO.contains(this.d)) {
          ((ProfileActivity.AllInOne)localObject1).bJa = 101;
        } else {
          ((ProfileActivity.AllInOne)localObject1).bJa = 102;
        }
      }
      j = 13;
    }
  }
  
  public boolean t(int paramInt)
  {
    return Arrays.binarySearch(this.ad, paramInt) >= 0;
  }
  
  public static class a
    extends abeg.a
  {
    public View An;
    public TextView Gn;
    public TextView LF;
    public TextView Pl;
    public TextView Pm;
    public PhoneContact e;
    public Button er;
    public CheckBox mCheckBox;
    public TextView nickname;
    
    public a()
    {
      this.type = 11;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(PhoneContact paramPhoneContact, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdz
 * JD-Core Version:    0.7.0.1
 */