import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class apol
  extends abdw
  implements View.OnClickListener
{
  private List<ChatHistoryTroopMemberFragment.a> Ib;
  apod jdField_a_of_type_Apod;
  private final apoj jdField_a_of_type_Apoj;
  private apon jdField_a_of_type_Apon;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  private int[] ad = new int[0];
  LinkedHashMap<ChatHistoryTroopMemberFragment.a, apoe> ai;
  QQAppInterface app;
  private final apnw jdField_b_of_type_Apnw;
  private TroopInfo jdField_b_of_type_ComTencentMobileqqDataTroopInfo;
  boolean cRG;
  public boolean cRM;
  private boolean cRN;
  private Context context;
  String cqk;
  private int dVb = 0;
  private String[] k = new String[0];
  
  public apol(apoj paramapoj, TroopChatPie paramTroopChatPie)
  {
    super(paramapoj.context, paramapoj.app, paramapoj.listView, true);
    this.app = paramapoj.app;
    this.context = paramapoj.context;
    this.jdField_a_of_type_Apoj = paramapoj;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    eaV();
    this.Ib = new ArrayList();
    this.ai = new LinkedHashMap();
    this.jdField_b_of_type_Apnw = new apnw(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo, this.app, this);
    this.jdField_a_of_type_Apon = new apon(this);
    eaT();
  }
  
  private void a(int paramInt, apol.a parama)
  {
    ChatHistoryTroopMemberFragment.a locala = (ChatHistoryTroopMemberFragment.a)this.Ib.get(paramInt);
    parama.pQ.setImageBitmap(e(locala.uin, 2));
    Object localObject = apof.b(locala);
    if (this.dVb == 1) {
      localObject = locala.bah;
    }
    localObject = new aofe((CharSequence)localObject, 16).k();
    parama.fe.setText((CharSequence)localObject);
    aqpm.a(this.app, parama.fe, (Spannable)localObject);
    parama.uin = locala.uin;
    parama.position = paramInt;
    apol.a.a(parama).setTag(parama);
    apol.a.a(parama).setOnClickListener(this);
    VipUtils.a(this.app, this.context, this.context.getResources(), parama, locala);
    c(parama, locala);
    if (this.ai.containsKey(locala))
    {
      parama.selectCheckBox.setChecked(true);
      if (this.jdField_a_of_type_Apon.cRO) {
        break label209;
      }
      parama.selectCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(parama, locala);
      b(parama, locala);
      return;
      parama.selectCheckBox.setChecked(false);
      break;
      label209:
      parama.selectCheckBox.setVisibility(0);
    }
  }
  
  private void a(apol.a parama)
  {
    if (!this.cRN) {
      this.cRN = true;
    }
    this.jdField_b_of_type_Apnw.ih(parama.mp);
    parama.mp.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL();
    this.jdField_b_of_type_Apnw.Tq((String)localObject);
    this.jdField_a_of_type_Apon.z(parama.pQ);
    localObject = (ChatHistoryTroopMemberFragment.a)this.Ib.get(0);
    if (this.ai.containsKey(localObject)) {
      parama.selectCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_Apon.cRO)
    {
      parama.selectCheckBox.setVisibility(8);
      return;
      parama.selectCheckBox.setChecked(false);
    }
    parama.selectCheckBox.setVisibility(0);
  }
  
  private void a(apol.a parama, ChatHistoryTroopMemberFragment.a parama1)
  {
    if (parama.IK != null)
    {
      aptw localaptw = (aptw)this.app.getManager(203);
      if ((localaptw == null) || (!localaptw.gM(parama1.uin))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      parama.IK.setVisibility(0);
      return;
    }
    parama.IK.setVisibility(8);
  }
  
  private void b(apol.a parama, ChatHistoryTroopMemberFragment.a parama1)
  {
    if (parama.aaY != null)
    {
      if (parama1.isTroopFollowed)
      {
        parama1 = apuh.k(this.context.getResources(), Color.parseColor("#FE988A"));
        parama.aaY.setBackgroundDrawable(parama1);
        parama.aaY.setVisibility(0);
      }
    }
    else {
      return;
    }
    parama.aaY.setVisibility(8);
  }
  
  private void c(apol.a parama, ChatHistoryTroopMemberFragment.a parama1)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(parama1.uin))
    {
      apol.a.a(parama).setVisibility(0);
      parama1 = apdg.a().a(true, false);
      apol.a.a(parama).setText(parama1.title);
      parama1 = apuh.k(this.context.getResources(), parama1.bgColor);
      apol.a.a(parama).setBackgroundDrawable(parama1);
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(parama1.uin))
    {
      apol.a.a(parama).setVisibility(0);
      parama1 = apdg.a().a(false, true);
      apol.a.a(parama).setText(parama1.title);
      parama1 = apuh.k(this.context.getResources(), parama1.bgColor);
      apol.a.a(parama).setBackgroundDrawable(parama1);
      return;
    }
    apol.a.a(parama).setVisibility(8);
  }
  
  private void c(ChatHistoryTroopMemberFragment.a parama)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Map.Entry localEntry = null;
    Object localObject2 = this.ai.entrySet().iterator();
    int i = 0;
    Object localObject1 = localEntry;
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      if (((ChatHistoryTroopMemberFragment.a)((Map.Entry)localObject1).getKey()).equals(parama)) {
        localObject1 = (apoe)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      parama = this.ai.entrySet().iterator();
      j = 0;
      label98:
      if (!parama.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)parama.next();
      if (j >= i) {
        break label157;
      }
      localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    for (;;)
    {
      j += 1;
      break label98;
      i += 1;
      break;
      label157:
      if ((j != i) && (localObject1 != null))
      {
        localObject2 = (apoe)localEntry.getValue();
        int n = ((apoe)localObject2).startIndex - ((apoe)localObject1).l.length();
        int m = n;
        if (n < 0) {
          m = 0;
        }
        localObject2 = new apoe(m, ((apoe)localObject2).l);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.ai = localLinkedHashMap;
  }
  
  private void d(ChatHistoryTroopMemberFragment.a parama)
  {
    parama = (apoe)this.ai.get(parama);
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getEditableText();
    if (parama != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + parama);
      }
      int i = parama.startIndex;
      int j = parama.startIndex;
      localEditable.delete(i, parama.l.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void e(ChatHistoryTroopMemberFragment.a parama)
  {
    if (this.ai.containsKey(parama)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", parama });
    }
    Object localObject;
    do
    {
      return;
      localObject = apof.a(parama);
      localObject = appb.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl, parama.uin, (String)localObject, apof.a(parama), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getEditableText();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getSelectionStart();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getText().toString().lastIndexOf("@", n);
    int j;
    if ((i1 != -1) && (apof.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a) < i1)) {
      j = 1;
    }
    for (int i = i1;; i = n)
    {
      int m = i;
      if (i < 0) {
        m = 0;
      }
      apoe localapoe = new apoe(m, (SpannableString)localObject);
      this.ai.put(parama, localapoe);
      if (j != 0) {
        localEditable.delete(i1, n);
      }
      localEditable.insert(m, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localapoe, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void eaT()
  {
    this.jdField_a_of_type_Apoj.listView.setOnScrollListener(new apom(this));
  }
  
  private void eaU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_Apoj.c;
    if (localIndexBar != null) {
      localIndexBar.setLetters(this.k);
    }
  }
  
  private void eaV()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl;
    this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.app.getManager(52)).b(str);
  }
  
  private void ij(View paramView)
  {
    paramView = ((apol.a)paramView.getTag()).selectCheckBox;
    if ((this.jdField_a_of_type_Apon.aBq()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_Apon.eaY();
    }
    do
    {
      return;
      this.jdField_b_of_type_Apnw.eaP();
    } while (!this.jdField_b_of_type_Apnw.aBn());
    ChatHistoryTroopMemberFragment.a locala = (ChatHistoryTroopMemberFragment.a)getItem(0);
    this.cRM = true;
    if (!paramView.isChecked())
    {
      e(locala);
      label79:
      if (paramView.isChecked()) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      this.cRM = false;
      this.jdField_b_of_type_Apnw.eaO();
      if ((this.jdField_a_of_type_Apon.cRO) || (this.jdField_a_of_type_Apod == null)) {
        break;
      }
      this.jdField_a_of_type_Apod.azJ();
      return;
      d(locala);
      c(locala);
      break label79;
    }
  }
  
  private void ik(View paramView)
  {
    boolean bool = true;
    Object localObject = (apol.a)paramView.getTag();
    paramView = ((apol.a)localObject).selectCheckBox;
    ChatHistoryTroopMemberFragment.a locala = (ChatHistoryTroopMemberFragment.a)getItem(((apol.a)localObject).position);
    this.cRM = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_Apon.aBq())
      {
        this.jdField_a_of_type_Apon.eaY();
        this.cRM = false;
        return;
      }
      e(locala);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.cRM = false;
      paramView = (aptw)this.app.getManager(203);
      if (((this.jdField_a_of_type_Apod != null) && (paramView.gM(locala.uin))) || ((this.jdField_a_of_type_Apod != null) && (!this.jdField_a_of_type_Apon.cRO))) {
        this.jdField_a_of_type_Apod.azJ();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(locala.bah)) || (!locala.bah.equals(locala.aRl))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      d(locala);
      c(locala);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(locala.bah))
      {
        paramView = (View)localObject;
        if (locala.bah.equals(locala.nickname)) {
          paramView = "3";
        }
      }
    }
  }
  
  public int Ly()
  {
    return this.dVb;
  }
  
  public void Ts(String paramString)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "unCheckItem ", paramString.toString() });
    }
    c(paramString);
    notifyDataSetChanged();
  }
  
  public apon a()
  {
    return this.jdField_a_of_type_Apon;
  }
  
  public void a(apod paramapod)
  {
    this.jdField_a_of_type_Apod = paramapod;
  }
  
  public boolean aBp()
  {
    if ((this.Ib == null) || (this.Ib.size() <= 0)) {
      return false;
    }
    return "0".equals(((ChatHistoryTroopMemberFragment.a)this.Ib.get(0)).uin);
  }
  
  public int ag()
  {
    return 0;
  }
  
  ChatHistoryTroopMemberFragment.a b(String paramString)
  {
    if ((this.Ib != null) && (this.Ib.size() > 0))
    {
      int j = this.Ib.size();
      int i = 0;
      while (i < j)
      {
        ChatHistoryTroopMemberFragment.a locala = (ChatHistoryTroopMemberFragment.a)this.Ib.get(i);
        if ((locala.uin != null) && (locala.uin.equals(paramString))) {
          return locala;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void b(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Apoj.c;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void b(apoo.a parama)
  {
    this.Ib = parama.Bu;
    this.ad = parama.oL;
    this.k = parama.hD;
    this.cqk = parama.keyWord;
    this.cRG = parama.cRP;
    this.jdField_b_of_type_Apnw.eaO();
    if (TextUtils.isEmpty(parama.keyWord))
    {
      this.dVb = 0;
      this.ai.clear();
    }
    for (;;)
    {
      eaU();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged start  " + System.currentTimeMillis());
      }
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged end  " + System.currentTimeMillis());
      }
      return;
      this.dVb = 1;
    }
  }
  
  public void destroy()
  {
    if (this.jdField_b_of_type_Apnw != null) {
      this.jdField_b_of_type_Apnw.destroy();
    }
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
  }
  
  public void eaW()
  {
    this.cRN = false;
  }
  
  public void eaX()
  {
    int i;
    if (this.ai != null)
    {
      i = this.ai.size();
      if (i != 1) {
        break label72;
      }
      anot.a(this.app, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.ai.clear();
      this.jdField_a_of_type_Apon.cRO = false;
      return;
      label72:
      if (i > 1) {
        anot.a(this.app, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public List<ChatHistoryTroopMemberFragment.a> gB()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.Ib == null) {
      return localArrayList;
    }
    localArrayList.addAll(this.Ib);
    return localArrayList;
  }
  
  public int getCount()
  {
    return this.Ib.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.Ib.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (aBp())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    label37:
    apol.a locala;
    if (getItemViewType(paramInt) == 1)
    {
      i = 1;
      if (paramView != null) {
        break label105;
      }
      if (i == 0) {
        break label86;
      }
      paramView = LayoutInflater.from(this.context).inflate(2131563266, paramViewGroup, false);
      locala = new apol.a(paramView);
      paramView.setTag(locala);
      label53:
      if (i == 0) {
        break label117;
      }
      a(locala);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      i = 0;
      break;
      label86:
      paramView = LayoutInflater.from(this.context).inflate(2131563265, paramViewGroup, false);
      break label37;
      label105:
      locala = (apol.a)paramView.getTag();
      break label53;
      label117:
      a(paramInt, locala);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
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
  
  public void mS(List<ChatHistoryTroopMemberFragment.a> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.Ib = paramList;
    notifyDataSetChanged();
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
      ik(paramView);
      continue;
      ij(paramView);
    }
  }
  
  public boolean t(int paramInt)
  {
    return false;
  }
  
  public static class a
    extends abeg.a
  {
    final View IK;
    private final ThemeLabelTextView a;
    TextView aaY;
    public final TextView fe;
    private final LinearLayout kX;
    final RelativeLayout mp;
    int position;
    final CheckBox selectCheckBox;
    
    a(View paramView)
    {
      this.pQ = ((ImageView)paramView.findViewById(2131369767));
      this.kX = ((LinearLayout)paramView.findViewById(2131369468));
      this.fe = ((TextView)paramView.findViewById(2131380814));
      this.selectCheckBox = ((CheckBox)paramView.findViewById(2131372074));
      this.a = ((ThemeLabelTextView)paramView.findViewById(2131380800));
      this.IK = paramView.findViewById(2131380904);
      this.aaY = ((TextView)paramView.findViewById(2131380938));
      this.mp = ((RelativeLayout)paramView.findViewById(2131362674));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apol
 * JD-Core Version:    0.7.0.1
 */