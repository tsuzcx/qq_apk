import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqcircle.beans.Friend;
import com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.4;
import com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.5;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class vjp
  extends aake
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  protected int a;
  protected aakf a;
  protected Activity a;
  protected SharedPreferences.Editor a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected View a;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  protected Button a;
  public CommentEditText a;
  private List<Friend> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected vjt a;
  private vju jdField_a_of_type_Vju;
  public boolean a;
  protected int b;
  protected View b;
  protected boolean b;
  protected boolean c;
  
  public vjp(Activity paramActivity)
  {
    super(paramActivity, 2131755408);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(a(), null);
    b();
    setCancelable(true);
    c();
    setContentView(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidViewView);
    d();
    setOnDismissListener(this);
    L_();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = Pattern.compile(paramString1, 16).matcher(paramString2).replaceFirst(paramString3);
      return str;
    }
    catch (Exception localException) {}
    return b(paramString2, paramString1, paramString3);
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {
      str1 = "";
    }
    Iterator localIterator;
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = paramString;
        } while (this.jdField_a_of_type_JavaUtilList == null);
        str1 = paramString;
      } while (this.jdField_a_of_type_JavaUtilList.size() == 0);
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      str1 = paramString;
    } while (!localIterator.hasNext());
    Friend localFriend = (Friend)localIterator.next();
    String str1 = localFriend.mName;
    if (TextUtils.isEmpty(str1)) {}
    for (str1 = localFriend.mUin + "";; str1 = str1.replace("%", "%25").replace(",", "%2C").replace("}", "%7D").replace("{", "%7B").replace(":", "%3A").replace(">", "%3E"))
    {
      str1 = "@{uin:" + localFriend.mUin + ",nick:" + str1 + "}";
      String str2 = "@" + localFriend.mName;
      if ((TextUtils.isEmpty(localFriend.mName)) || (!paramString.contains(str2))) {
        break;
      }
      paramString = a(str2, paramString, str1);
      break;
    }
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString2, 0);
    if (i == -1) {
      return paramString1;
    }
    paramString1 = new StringBuilder(paramString1);
    paramString1.replace(i, paramString2.length() + i, paramString3);
    return paramString1.toString();
  }
  
  @TargetApi(19)
  public void L_()
  {
    int i = 0;
    super.L_();
    Object localObject = getWindow();
    if (localObject == null) {}
    label101:
    for (;;)
    {
      return;
      localObject = ((Window)localObject).getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        localObject = ((ViewGroup)localObject).getChildAt(0);
        if ((localObject instanceof ViewGroup))
        {
          int j = ((ViewGroup)localObject).getChildCount();
          for (;;)
          {
            if (i >= j) {
              break label101;
            }
            View localView = ((ViewGroup)localObject).getChildAt(i);
            if ((localView == null) || (localView.getId() == 16908290)) {
              break;
            }
            if (!(localView instanceof ViewStub)) {
              localView.setAlpha(0.0F);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  protected abstract int a();
  
  protected Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return "";
    }
    String str = "";
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof behe))
    {
      localObject = (behe)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
      if (localObject == null) {
        break label167;
      }
      localObject = ((behe)localObject).a();
    }
    for (;;)
    {
      localObject = b(bnqj.b(((String)localObject).replaceAll(anzj.a(2131704694), anzj.a(2131704696)).replaceAll(anzj.a(2131704693), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(2131716430), "/chigua")));
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return ((String)localObject).trim();
      localObject = str;
      if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof begz))
      {
        begz localbegz = (begz)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
        localObject = str;
        if (localbegz != null)
        {
          localObject = localbegz.a();
          continue;
          label167:
          localObject = "";
        }
      }
    }
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    Matcher localMatcher = QCircleAsyncTextView.a.matcher(paramString);
    int i = 0;
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start();
        int k = localMatcher.end();
        Object localObject = localMatcher.group();
        int n = ((String)localObject).indexOf("uin:");
        int i1 = "uin:".length();
        int m = ((String)localObject).indexOf(",nick:");
        String str1 = ((String)localObject).substring(n + i1, m);
        n = ((String)localObject).length();
        String str2 = ((String)localObject).substring(m + ",nick:".length(), n - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
        String str3 = "@" + str2;
        paramString.replace(j - i, k - i, str3);
        i = ((String)localObject).length() - str3.length() + i;
        localObject = new Friend();
        ((Friend)localObject).mName = str2;
        try
        {
          ((Friend)localObject).mUin = Long.valueOf(str1).longValue();
          if (this.jdField_a_of_type_JavaUtilList == null) {
            this.jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("QCircleBaseInputPopupWindow", 1, localNumberFormatException, new Object[0]);
        }
      }
      return paramString.toString();
    }
    catch (Exception localException)
    {
      QLog.e("QCircleBaseInputPopupWindow", 1, localException, new Object[0]);
    }
  }
  
  protected abstract void a(View paramView);
  
  public void a(QCircleAtUpdateEvent paramQCircleAtUpdateEvent)
  {
    if ((paramQCircleAtUpdateEvent == null) || (paramQCircleAtUpdateEvent.mData == null) || (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null))
    {
      b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
      return;
    }
    Object localObject2;
    Friend localFriend;
    if (paramQCircleAtUpdateEvent.mData.getExtras() != null)
    {
      int i = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getSelectionStart();
      Object localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getEditableText();
      if (localObject1.toString().substring(i - 1, i).equals("@")) {
        ((Editable)localObject1).delete(i - 1, i);
      }
      localObject1 = paramQCircleAtUpdateEvent.mData.getParcelableArrayListExtra("result_set");
      if (localObject1 != null)
      {
        paramQCircleAtUpdateEvent = "";
        localObject1 = ((ArrayList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          localFriend = new Friend();
          if (!TextUtils.isEmpty(((ResultRecord)localObject2).b)) {
            localFriend.mName = ((ResultRecord)localObject2).b;
          }
        }
      }
    }
    label340:
    for (;;)
    {
      try
      {
        long l = Long.valueOf(((ResultRecord)localObject2).a).longValue();
        localFriend.mUin = l;
        if ((localFriend.mName == null) || (localFriend.mUin == 0L)) {
          break label340;
        }
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilList.add(localFriend);
        localObject2 = "@" + localFriend.mName + " ";
        paramQCircleAtUpdateEvent = paramQCircleAtUpdateEvent + (String)localObject2;
      }
      catch (NumberFormatException localNumberFormatException) {}
      localFriend.mName = ((ResultRecord)localObject2).a;
      continue;
      if (!TextUtils.isEmpty(paramQCircleAtUpdateEvent)) {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getEditableText().insert(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getSelectionStart(), paramQCircleAtUpdateEvent);
      }
      b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
      return;
      break;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(paramString);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setSelection(paramString.length());
  }
  
  public void a(vjt paramvjt)
  {
    this.jdField_a_of_type_Vjt = paramvjt;
  }
  
  public void a(vju paramvju)
  {
    this.jdField_a_of_type_Vju = paramvju;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return 0;
    }
    int j = bdep.c(this.jdField_a_of_type_AndroidAppActivity) - this.jdField_a_of_type_Int - bdep.a(95.0F);
    int i = j;
    if (bdep.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      int k = bdep.d(this.jdField_a_of_type_AndroidAppActivity);
      i = j - k;
      QLog.i("QCircleBaseInputPopupWindow", 1, "getInputLayoutLocationYOnScreen  NavigationBarHeight : " + k);
    }
    QLog.i("QCircleBaseInputPopupWindow", 1, "getInputLayoutLocationYOnScreen  yOnScreen : " + i);
    return i;
  }
  
  protected void b()
  {
    if ((getWindow() != null) && (getWindow().getAttributes() != null))
    {
      Window localWindow = getWindow();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setSoftInputMode(16);
    }
  }
  
  public void b(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new QCircleBaseInputPopupWindow.4(this, paramView));
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setHint(paramString);
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText = ((CommentEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131378684));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnInputBackListener(new vjq(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setEditableFactory(behe.c);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.a();
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363885));
    this.jdField_a_of_type_AndroidContentSharedPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("GroupSoftKeyboardHeight", agej.a(250.0F, getContext().getResources()));
    QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel initView() step1 :" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = bdep.a(250.0F);
      QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel initView() step2 :" + this.jdField_a_of_type_Int);
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363548);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new vjr(this));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method"));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void c(View paramView)
  {
    paramView.post(new QCircleBaseInputPopupWindow.5(this, paramView));
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void d(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void dismiss()
  {
    c(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    super.dismiss();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new vjs(this));
      this.jdField_a_of_type_AndroidViewView.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.start();
    }
  }
  
  protected void e(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SelectMemberActivity.class);
      localIntent.putExtra("param_only_friends", true);
      localIntent.putExtra("param_min", 1);
      localIntent.putExtra("param_max", bmaa.l());
      localIntent.putExtra("param_entrance", 42);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 300002);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Aakf != null)
    {
      this.jdField_a_of_type_Aakf.a();
      this.jdField_a_of_type_Aakf = null;
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Vju != null) {
      this.jdField_a_of_type_Vju.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjp
 * JD-Core Version:    0.7.0.1
 */