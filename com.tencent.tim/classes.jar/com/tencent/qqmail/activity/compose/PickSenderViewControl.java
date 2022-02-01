package com.tencent.qqmail.activity.compose;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.alias.AliasItem;
import com.tencent.qqmail.model.alias.QMAliasManager;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.ComposeData;
import com.tencent.qqmail.model.qmdomain.ComposeData.ComposeDataSender;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogBuilder;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class PickSenderViewControl
{
  private static final HashMap<String, Integer> DOMAIN_ORDER_MAP = new HashMap(10);
  private static final int DOMAIN_ORDER_MAP_CAPACITY = 10;
  private static final String TAG = "PickSenderViewControl";
  private PickerViewControlAdapter adapter;
  private boolean animating;
  private SenderPickerViewControlCallback callback;
  private ComposeData composeData;
  private List<AliasItem> data = null;
  boolean isNickChange = false;
  private boolean loadError;
  private LinearLayout mContainer;
  private QMUIDialog mDialog;
  private int mDialogOriginHeight;
  private boolean mHasGetOriginHeight = false;
  private ListView mListView;
  private EditText mNickNameEditText;
  private String nick = "";
  private boolean pickerShown;
  private int sChooseAccountId = -1;
  private String sChooseName = "";
  private int selectedRow = 0;
  private String title = "";
  private boolean unableProtocol = false;
  
  static
  {
    DOMAIN_ORDER_MAP.put("@qq.com", Integer.valueOf(0));
    DOMAIN_ORDER_MAP.put("@vip.qq.com", Integer.valueOf(1));
    DOMAIN_ORDER_MAP.put("@exmail.qq.com", Integer.valueOf(2));
    DOMAIN_ORDER_MAP.put("@rdgz.org", Integer.valueOf(3));
    DOMAIN_ORDER_MAP.put("@foxmail.com", Integer.valueOf(4));
    DOMAIN_ORDER_MAP.put("@tencent.com", Integer.valueOf(5));
    DOMAIN_ORDER_MAP.put("@163.com", Integer.valueOf(6));
    DOMAIN_ORDER_MAP.put("@126.com", Integer.valueOf(7));
    DOMAIN_ORDER_MAP.put("@gmail.com", Integer.valueOf(8));
    DOMAIN_ORDER_MAP.put("@hotmail.com", Integer.valueOf(9));
  }
  
  private void hide()
  {
    if (!this.pickerShown) {
      return;
    }
    this.mDialog.dismiss();
    this.pickerShown = true;
  }
  
  private boolean isExistAlias(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.data != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.data.size())
      {
        if ((this.data.get(i) != null) && (((AliasItem)this.data.get(i)).getAlias() != null) && (((AliasItem)this.data.get(i)).getAlias().equals(paramString))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private String nickOfAlias(int paramInt, String paramString)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localObject == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      if (!((Account)localObject).isQQMail()) {
        break;
      }
      if (!QMComposeDataManager.sharedInstance().getQMAliasIndep(paramString, paramInt)) {
        return QMComposeDataManager.sharedInstance().getQMDefaultNick(paramInt);
      }
      localObject = QMComposeDataManager.sharedInstance().getQMAliasNick(paramString, paramInt);
      paramString = (String)localObject;
    } while (!StringUtils.isEmpty((CharSequence)localObject));
    return QMComposeDataManager.sharedInstance().getQMDefaultNick(paramInt);
    return QMSettingManager.sharedInstance().getAccountNick(paramInt);
  }
  
  private void onRowSelected(Dialog paramDialog, int paramInt, View paramView)
  {
    paramDialog = (AliasItem)this.adapter.getItem(paramInt);
    if ((this.unableProtocol) && (paramDialog.isProtocol())) {
      return;
    }
    checkNick(this.mNickNameEditText.getText().toString());
    if (this.isNickChange)
    {
      DataCollector.logEvent("Event_Compose_Set_Nick");
      saveNickName(this.mNickNameEditText.getContext(), this.mNickNameEditText.getText().toString(), this.sChooseName, this.sChooseAccountId);
    }
    this.selectedRow = paramInt;
    this.sChooseName = paramDialog.getAlias();
    this.sChooseAccountId = paramDialog.getAccountId();
    String str = nickOfAlias(this.sChooseAccountId, this.sChooseName);
    EditText localEditText = this.mNickNameEditText;
    if (str == null) {}
    for (paramDialog = "";; paramDialog = str)
    {
      localEditText.setText(paramDialog);
      this.nick = str;
      this.mNickNameEditText.clearFocus();
      this.mListView.requestFocus();
      ((InputMethodManager)this.mListView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mListView.getWindowToken(), 0);
      if (this.callback == null) {
        break;
      }
      paramView.postDelayed(new PickSenderViewControl.5(this), 100L);
      return;
    }
  }
  
  private ArrayList<AliasItem> parseAliasItems(ComposeData paramComposeData)
  {
    int j = paramComposeData.getAccountId();
    paramComposeData = paramComposeData.getItems();
    ArrayList localArrayList = new ArrayList();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(j);
    if ((paramComposeData != null) && (paramComposeData.size() > 0) && (localAccount != null))
    {
      int i = 0;
      if (i < paramComposeData.size())
      {
        String str = ((ComposeData.ComposeDataSender)paramComposeData.get(i)).getAlias();
        AliasItem localAliasItem = new AliasItem();
        localAliasItem.initByComposeData((ComposeData.ComposeDataSender)paramComposeData.get(i), j);
        if (!localAccount.isQQMail()) {}
        for (boolean bool = true;; bool = false)
        {
          localAliasItem.setIsProtocol(bool);
          if ((!isExistAlias(str)) && (!StringUtils.isEmpty(str))) {
            localArrayList.add(localAliasItem);
          }
          i += 1;
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void saveNickName(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1.length() > 32)
    {
      Toast.makeText(paramContext, "昵称不能超过32个字符", 0).show();
      return;
    }
    paramContext = AccountManager.shareInstance().getAccountList().getAccountById(getChooseAccountId());
    if ((paramContext != null) && (paramContext.isQQMail()))
    {
      paramContext = new QMCallback();
      paramContext.setOnSuccess(new PickSenderViewControl.3(this));
      paramContext.setOnError(new PickSenderViewControl.4(this));
      if (QMComposeDataManager.sharedInstance().getQMAliasIndep(paramString2, paramInt))
      {
        QMComposeDataManager.sharedInstance().setQMAliasNick(paramInt, paramString2, paramString1);
        QMAliasManager.shareInstance().syncQMAliasNick(paramString2, paramInt, paramString1, paramContext);
      }
    }
    for (;;)
    {
      this.isNickChange = false;
      return;
      QMComposeDataManager.sharedInstance().setQMDefaultNick(paramInt, paramString1);
      QMAliasManager.shareInstance().syncQMAccountDefaultNick(paramInt, paramString1, paramContext);
      continue;
      QMSettingManager.sharedInstance().setAccountNick(paramInt, paramString1);
      QMPrivateProtocolManager.sharedInstance().setAccountNick(paramInt, paramString1);
    }
  }
  
  public void appendData(List<AliasItem> paramList)
  {
    if (this.data == null)
    {
      this.data = paramList;
      return;
    }
    paramList = paramList.iterator();
    label20:
    label41:
    label116:
    label123:
    label126:
    for (;;)
    {
      AliasItem localAliasItem1;
      if (paramList.hasNext())
      {
        localAliasItem1 = (AliasItem)paramList.next();
        i = 0;
        if (i >= this.data.size()) {
          break label123;
        }
        AliasItem localAliasItem2 = (AliasItem)this.data.get(i);
        if (!StringUtils.equals(localAliasItem1.getAlias(), localAliasItem2.getAlias())) {
          break label116;
        }
        this.data.set(i, localAliasItem1);
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label126;
        }
        this.data.add(localAliasItem1);
        break label20;
        break;
        i += 1;
        break label41;
      }
    }
  }
  
  public void checkNick(String paramString)
  {
    if (paramString == null) {}
    while (paramString.equals(this.nick)) {
      return;
    }
    this.isNickChange = true;
  }
  
  public void dismissPickerView()
  {
    if (this.pickerShown)
    {
      if (this.callback != null) {
        this.callback.dismissSenderPickerView(null);
      }
      hide();
    }
  }
  
  public SenderPickerViewControlCallback getCallback()
  {
    return this.callback;
  }
  
  public int getChooseAccountId()
  {
    return this.sChooseAccountId;
  }
  
  public String getChooseName()
  {
    return this.sChooseName;
  }
  
  public ComposeData getComposeData()
  {
    return this.composeData;
  }
  
  public List<AliasItem> getData()
  {
    return this.data;
  }
  
  public String getNick()
  {
    return this.nick;
  }
  
  public int getSelectedRow()
  {
    return this.selectedRow;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void init() {}
  
  public boolean isAnimating()
  {
    return this.animating;
  }
  
  public boolean isLoadError()
  {
    return this.loadError;
  }
  
  public boolean isPickerShown()
  {
    return this.pickerShown;
  }
  
  public boolean isUnableProtocol()
  {
    return this.unableProtocol;
  }
  
  public void loadComposeData(ComposeData paramComposeData)
  {
    this.composeData = paramComposeData;
    if (this.data == null)
    {
      this.data = parseAliasItems(this.composeData);
      return;
    }
    this.data.addAll(parseAliasItems(this.composeData));
  }
  
  public void setAnimating(boolean paramBoolean)
  {
    this.animating = paramBoolean;
  }
  
  public void setCallback(SenderPickerViewControlCallback paramSenderPickerViewControlCallback)
  {
    this.callback = paramSenderPickerViewControlCallback;
  }
  
  public void setComposeData(ComposeData paramComposeData)
  {
    this.composeData = paramComposeData;
  }
  
  public void setDefaultSelect(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      this.sChooseName = paramString;
    }
    for (;;)
    {
      if ((this.composeData == null) || (this.data == null)) {}
      for (;;)
      {
        return;
        if (this.composeData == null) {
          break label128;
        }
        paramString = this.composeData.getDefaultName();
        break;
        int i = 0;
        while (i < this.data.size())
        {
          String str = ((AliasItem)this.data.get(i)).getAlias();
          if ((str != null) && (str.equals(paramString)))
          {
            this.selectedRow = i;
            this.sChooseAccountId = ((AliasItem)this.data.get(i)).getAccountId();
            return;
          }
          i += 1;
        }
      }
      label128:
      paramString = "";
    }
  }
  
  public void setEditTextFilter(EditText paramEditText, int paramInt)
  {
    paramEditText.setFilters(new InputFilter[] { new CountInputFilter(paramInt, paramEditText.getContext()) });
  }
  
  public void setLoadError(boolean paramBoolean)
  {
    this.loadError = paramBoolean;
  }
  
  public void setPickerShown(boolean paramBoolean)
  {
    this.pickerShown = paramBoolean;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUnableProtocol(boolean paramBoolean)
  {
    this.unableProtocol = paramBoolean;
    if (this.adapter != null) {
      this.adapter.setUnableProtocol(paramBoolean);
    }
  }
  
  public void setsChooseAccountId(int paramInt)
  {
    this.sChooseAccountId = paramInt;
  }
  
  public void setsChooseName(String paramString)
  {
    this.sChooseName = paramString;
  }
  
  public boolean show()
  {
    if ((this.data == null) || (this.data.size() <= 1)) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = this.callback.getSenderActivity();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    if (this.mDialog == null)
    {
      this.mDialog = ((PickSenderDialogBuilder)((PickSenderDialogBuilder)((PickSenderDialogBuilder)new PickSenderDialogBuilder(localActivity).setTitle(this.title)).addAction(2131691246, new PickSenderViewControl.2(this))).addAction(2131696547, new PickSenderViewControl.1(this))).create();
      this.pickerShown = true;
      this.mDialog.show();
      return true;
    }
    this.pickerShown = true;
    this.mDialog.show();
    return true;
  }
  
  public void sortData()
  {
    if ((this.data == null) || (this.data.size() <= 1)) {
      return;
    }
    Collections.sort(this.data, new PickSenderViewControl.6(this));
  }
  
  public class CountInputFilter
    implements InputFilter
  {
    private Context mContext;
    private int mMaxCount;
    
    public CountInputFilter(int paramInt, Context paramContext)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        this.mMaxCount = paramInt;
        this.mContext = paramContext;
        return;
        paramInt = 0;
      }
    }
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      Object localObject = paramCharSequence;
      if (paramSpanned.toString().length() + paramCharSequence.toString().length() > this.mMaxCount)
      {
        Toast.makeText(this.mContext, "昵称不能超过" + this.mMaxCount + "个字符", 0).show();
        localObject = "";
      }
      return localObject;
    }
  }
  
  public class PickSenderDialogBuilder
    extends QMUIDialogBuilder<PickSenderDialogBuilder>
  {
    private int mAnchorHeight = 0;
    private Context mContext;
    private int mListViewHeight = 0;
    private LinearLayout.LayoutParams mListViewLp;
    private LinearLayout mNickHeader;
    private int mOldScreenHeight = 0;
    private int mScreenHeight = 0;
    
    public PickSenderDialogBuilder(Context paramContext)
    {
      super();
      this.mContext = paramContext;
    }
    
    public void onAfter(QMUIDialog paramQMUIDialog, LinearLayout paramLinearLayout)
    {
      super.onAfter(paramQMUIDialog, paramLinearLayout);
      this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new PickSenderViewControl.PickSenderDialogBuilder.2(this));
    }
    
    public void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
    {
      PickSenderViewControl.access$902(PickSenderViewControl.this, (LinearLayout)LayoutInflater.from(this.mContext).inflate(2131559237, paramViewGroup, true));
      this.mNickHeader = ((LinearLayout)PickSenderViewControl.this.mContainer.findViewById(2131373282));
      PickSenderViewControl.access$002(PickSenderViewControl.this, (EditText)PickSenderViewControl.this.mContainer.findViewById(2131373283));
      PickSenderViewControl.access$1002(PickSenderViewControl.this, (ListView)PickSenderViewControl.this.mContainer.findViewById(2131373281));
      this.mListViewLp = ((LinearLayout.LayoutParams)PickSenderViewControl.this.mListView.getLayoutParams());
      PickSenderViewControl.this.mContainer.requestFocus();
      PickSenderViewControl.this.mNickNameEditText.setText(PickSenderViewControl.this.nickOfAlias(PickSenderViewControl.this.sChooseAccountId, PickSenderViewControl.this.sChooseName));
      PickSenderViewControl.access$102(PickSenderViewControl.this, PickSenderViewControl.this.mNickNameEditText.getText().toString());
      PickSenderViewControl.this.setEditTextFilter(PickSenderViewControl.this.mNickNameEditText, 32);
      PickSenderViewControl.this.mNickNameEditText.setSelection(PickSenderViewControl.this.mNickNameEditText.getText().length());
      if (PickSenderViewControl.this.adapter == null)
      {
        paramViewGroup = PickSenderViewControl.this.callback.getSenderActivity();
        if ((paramViewGroup == null) || (paramViewGroup.isFinishing())) {
          return;
        }
        PickSenderViewControl.access$702(PickSenderViewControl.this, new PickSenderViewControl.PickerViewControlAdapter(paramViewGroup, 2131559769, PickSenderViewControl.this.data, PickSenderViewControl.this.sChooseName));
        PickSenderViewControl.this.adapter.setUnableProtocol(PickSenderViewControl.this.unableProtocol);
      }
      PickSenderViewControl.this.mListView.setAdapter(PickSenderViewControl.this.adapter);
      PickSenderViewControl.this.mListView.setOnItemClickListener(new PickSenderViewControl.PickSenderDialogBuilder.1(this, paramQMUIDialog));
    }
  }
  
  static class PickerViewControlAdapter
    extends ArrayAdapter<AliasItem>
  {
    private String chooseName;
    private int resId;
    private boolean unableProtocol = false;
    
    public PickerViewControlAdapter(Context paramContext, int paramInt, List<AliasItem> paramList, String paramString)
    {
      super(paramInt, paramList);
      this.resId = paramInt;
      this.chooseName = paramString;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = LayoutInflater.from(getContext()).inflate(this.resId, paramViewGroup, false);
      }
      for (;;)
      {
        AliasItem localAliasItem = (AliasItem)getItem(paramInt);
        String str = localAliasItem.getAlias();
        TextView localTextView = (TextView)paramView.findViewById(2131379870);
        localTextView.setText(str + QMUIKit.ELLIPSIZE_FIXED);
        localTextView.getPaddingLeft();
        if ((this.unableProtocol) && (localAliasItem.isProtocol()))
        {
          paramView.setSelected(false);
          ((CheckBox)paramView.findViewById(2131373279)).setChecked(false);
          localTextView.setTextColor(getContext().getResources().getColor(2131166574));
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
        }
        if (this.chooseName.equals(str))
        {
          paramView.setSelected(true);
          ((CheckBox)paramView.findViewById(2131373279)).setChecked(true);
        }
        for (;;)
        {
          localTextView.setTextColor(getContext().getResources().getColor(2131166572));
          QMUIKit.setBackgroundKeepingPadding(localTextView, 2130845605);
          break;
          paramView.setSelected(false);
          ((CheckBox)paramView.findViewById(2131373279)).setChecked(false);
        }
      }
    }
    
    public boolean isUnableProtocol()
    {
      return this.unableProtocol;
    }
    
    public void setChooseName(String paramString)
    {
      this.chooseName = paramString;
      notifyDataSetChanged();
    }
    
    public void setUnableProtocol(boolean paramBoolean)
    {
      this.unableProtocol = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public static abstract interface SenderPickerViewControlCallback
  {
    public abstract void didSelectRow(PickSenderViewControl paramPickSenderViewControl, int paramInt);
    
    public abstract void dismissSenderPickerView(View paramView);
    
    public abstract Activity getSenderActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.PickSenderViewControl
 * JD-Core Version:    0.7.0.1
 */