package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQServiceEntry;
import com.tencent.mobileqq.app.QQServiceEntry.Tag;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.MotionViewSetter;
import cpg;
import cph;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class ForwardRecentListAdapter
  extends BaseAdapter
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 80;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  public QQAppInterface a;
  private QQServiceEntry jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry;
  private FriendManager jdField_a_of_type_ComTencentMobileqqModelFriendManager;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private MotionViewSetter jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = null;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable(3);
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = null;
  private View.OnLongClickListener jdField_b_of_type_AndroidViewView$OnLongClickListener = new cpg(this);
  private String jdField_b_of_type_JavaLangString;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_c_of_type_JavaLangString;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_d_of_type_JavaLangString;
  private Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_e_of_type_JavaLangString = "yyyy-MM-dd";
  private Drawable jdField_f_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_f_of_type_JavaLangString = "";
  private Drawable g;
  private Drawable h;
  private Drawable i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  
  public ForwardRecentListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, QQServiceEntry paramQQServiceEntry, int paramInt, List paramList, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry = paramQQServiceEntry;
    a(paramQQAppInterface);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.a(1));
    if (this.jdField_a_of_type_Float < 1.5D) {
      this.jdField_a_of_type_Int = 160;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    b();
    c();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839352);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839346);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839357);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramQQAppInterface.a(BitmapFactory.decodeResource(paramContext.getResources(), 2130838051));
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = paramQQAppInterface.a(BitmapFactory.decodeResource(paramContext.getResources(), 2130838049));
    this.jdField_f_of_type_AndroidGraphicsDrawableDrawable = paramQQAppInterface.a(BitmapFactory.decodeResource(paramContext.getResources(), 2130838052));
    this.i = paramContext.getResources().getDrawable(2130839063);
    this.j = paramContext.getResources().getDrawable(2130839064);
    this.h = paramContext.getResources().getDrawable(2130839062);
    this.k = paramContext.getResources().getDrawable(2130839061);
    this.l = paramContext.getResources().getDrawable(2130839065);
    this.g = paramContext.getResources().getDrawable(2130838103);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363809);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131363810);
    this.jdField_c_of_type_JavaLangString = paramContext.getString(2131363811);
    this.jdField_d_of_type_JavaLangString = paramContext.getString(2131363812);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)paramQQAppInterface.a(2));
  }
  
  private SpannableString a(CharSequence paramCharSequence1, Drawable paramDrawable, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramCharSequence1 != null)
    {
      paramCharSequence1 = paramCharSequence1 + ": ";
      localStringBuffer.append(paramCharSequence1);
    }
    for (int m = paramCharSequence1.length();; m = 0)
    {
      if (paramBoolean) {
        localStringBuffer.append("-");
      }
      if (paramDrawable != null) {
        localStringBuffer.append("-");
      }
      if (paramCharSequence2 != null) {
        localStringBuffer.append(paramCharSequence2);
      }
      paramCharSequence1 = new SpannableString(localStringBuffer.toString());
      if (paramBoolean)
      {
        this.k.setBounds(0, 0, this.i.getIntrinsicWidth(), this.i.getIntrinsicHeight());
        paramCharSequence1.setSpan(new ImageSpan(this.k), m, m + 1, 33);
      }
      if (paramDrawable != null) {
        if (!paramBoolean) {
          break label203;
        }
      }
      label203:
      for (int n = 1;; n = 0)
      {
        m = n + m;
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        paramCharSequence1.setSpan(new ImageSpan(paramDrawable), m, m + 1, 33);
        return paramCharSequence1;
      }
    }
  }
  
  private SpannableString a(CharSequence paramCharSequence1, String paramString, CharSequence paramCharSequence2, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramCharSequence1 != null)
    {
      paramCharSequence1 = paramCharSequence1 + ": ";
      localStringBuffer.append(paramCharSequence1);
    }
    for (int m = paramCharSequence1.length();; m = 0)
    {
      if (paramBoolean1)
      {
        localStringBuffer.append("F ");
        if (paramString != null) {
          localStringBuffer.append(paramString);
        }
        if (paramCharSequence2 != null) {
          localStringBuffer.append(paramCharSequence2);
        }
        paramCharSequence1 = new SpannableString(localStringBuffer.toString());
        if (!paramBoolean1) {
          break label167;
        }
        this.k.setBounds(0, 0, this.i.getIntrinsicWidth(), this.i.getIntrinsicHeight());
        paramCharSequence1.setSpan(new ImageSpan(this.k), m, m + 1, 33);
      }
      label167:
      while (!paramBoolean2)
      {
        return paramCharSequence1;
        if (!paramBoolean2) {
          break;
        }
        localStringBuffer.append("S ");
        break;
      }
      this.l.setBounds(0, 0, this.l.getIntrinsicWidth() * 2 / 3, this.l.getIntrinsicHeight() * 2 / 3);
      paramCharSequence1.setSpan(new ImageSpan(this.l), m, m + 1, 33);
      return paramCharSequence1;
    }
  }
  
  private String a(String paramString, long paramLong)
  {
    Object localObject = (HashMap)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if ((localObject == null) || (!b()))
    {
      localObject = new HashMap();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      localObject = TimeFormatterUtils.a(1000L * paramLong, true, this.jdField_e_of_type_JavaLangString);
      paramString.put(paramLong + "", localObject);
      paramString = (String)localObject;
      String str;
      do
      {
        return paramString;
        str = (String)((HashMap)localObject).get(paramLong + "");
        paramString = str;
      } while (str != null);
      ((HashMap)localObject).clear();
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {}
    while (paramString.indexOf("http://maps.google.com/maps?q=") == -1) {
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString, boolean paramBoolean, long paramLong)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong);
    return ((paramString instanceof BuddyTransfileProcessor)) && (paramBoolean) && (paramString != null) && (((BuddyTransfileProcessor)paramString).b() >= 0) && (((BuddyTransfileProcessor)paramString).b() != 100);
  }
  
  private void b()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
  }
  
  private boolean b()
  {
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      b();
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      return false;
    }
    return true;
  }
  
  private boolean b(String paramString)
  {
    return ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramString);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    Hashtable localHashtable;
    do
    {
      return;
      localHashtable = new Hashtable();
      int m = 0;
      while (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        int n = TimeFormatterUtils.a(((RecentUser)this.jdField_a_of_type_JavaUtilList.get(m)).lastmsgtime * 1000L, null);
        if (!localHashtable.containsValue(Integer.valueOf(n))) {
          localHashtable.put(Integer.valueOf(m), Integer.valueOf(n));
        }
        m += 1;
      }
    } while (localHashtable.isEmpty());
    this.jdField_a_of_type_JavaUtilHashtable = localHashtable;
  }
  
  public QQCustomDialog a(String paramString1, String paramString2)
  {
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!"".equals(paramString1)) {}
    }
    else
    {
      str = paramString2;
    }
    return DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(str).setItems(2131230720, new cph(this, paramString2));
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilHashMap != null) {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)paramQQAppInterface.a(2));
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)paramQQAppInterface.getManager(8));
  }
  
  public void a(MotionViewSetter paramMotionViewSetter)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = paramMotionViewSetter;
  }
  
  public void a(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131296453);
    paramView = (Object[])paramView.getTag(2131296439);
    if (paramView != null)
    {
      boolean bool = ((Boolean)paramView[0]).booleanValue();
      paramView = SkinUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, bool));
      paramString = paramView;
      if (bool) {
        paramString = ImageUtil.a(paramView);
      }
      localImageView.setBackgroundDrawable(new BitmapDrawable(paramString));
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    c();
    super.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(String paramString) {}
  
  public void c(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Int, null);
    }
    localView.setTag(-1, Integer.valueOf(paramInt));
    RecentUser localRecentUser = (RecentUser)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localView.setTag(2131296879, Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    TextView localTextView = (TextView)localView.findViewById(16908308);
    ImageView localImageView = (ImageView)localView.findViewById(2131296453);
    if (localTextView != null)
    {
      localTextView.setMaxWidth(2147483647);
      localTextView.getLayoutParams().width = -1;
    }
    String str = localRecentUser.uin;
    int n = localRecentUser.type;
    paramView = "";
    Object localObject1 = null;
    QQServiceEntry.Tag localTag = (QQServiceEntry.Tag)localImageView.getTag();
    if (localTag == null) {
      localTag = new QQServiceEntry.Tag();
    }
    for (;;)
    {
      localView.setTag(2131296439, null);
      localView.setTag(2131298451, Integer.valueOf(n));
      paramViewGroup = null;
      Object localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        if (n != 5000) {
          break label599;
        }
        localObject2 = TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject2 != null)
        {
          paramView = ((TroopAssistantData)localObject2).troopUin;
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((TroopAssistantData)localObject2).troopUin, 1);
        }
        localObject2 = paramViewGroup;
      }
      for (;;)
      {
        label297:
        Object localObject3;
        if (localObject2 != null)
        {
          if ((((QQMessageFacade.Message)localObject2).istroop == 3000) && (((QQMessageFacade.Message)localObject2).msg == null) && (((QQMessageFacade.Message)localObject2).time == 0L))
          {
            a(str, localRecentUser.lastmsgtime);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
          }
        }
        else
        {
          localObject3 = (ImageView)localView.findViewById(2131298866);
          switch (n)
          {
          default: 
            paramView = null;
            paramViewGroup = (ViewGroup)localObject1;
            label477:
            if (paramView != null)
            {
              localObject1 = paramView;
              if (!"".equals(paramView)) {}
            }
            else
            {
              localObject1 = str;
            }
            localTextView.setText((CharSequence)localObject1);
            localImageView.setBackgroundDrawable(paramViewGroup);
          }
        }
        try
        {
          l1 = Long.valueOf(str).longValue();
          if ((l1 <= 10000L) && (1006 != localRecentUser.type)) {
            localImageView.setImageDrawable(null);
          }
          localTag.jdField_a_of_type_JavaLangString = str;
          localTag.jdField_b_of_type_JavaLangString = ((String)localObject1);
          localTag.jdField_a_of_type_Int = n;
          localImageView.setTag(localTag);
          if (this.jdField_a_of_type_Boolean)
          {
            float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
            return localView;
            label599:
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, n);
            continue;
            a(str, ((QQMessageFacade.Message)localObject2).time);
            break label297;
            paramView = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
            paramViewGroup = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c(str);
            if (paramViewGroup != null) {
              paramView = paramViewGroup.name;
            }
            for (;;)
            {
              paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, (byte)3);
              break;
              if (paramView != null) {
                paramView = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, true);
              } else {
                paramView = str;
              }
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(str);
            if ((localObject1 == null) || (((Friends)localObject1).uin == null) || (((Friends)localObject1).uin.length() <= 0)) {
              break label1998;
            }
            paramView = ContactUtils.a((Friends)localObject1);
            label800:
            int i1;
            label850:
            int m;
            if ((n == 1000) || (n == 1020))
            {
              paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.g(localRecentUser.troopUin);
              paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramView, localRecentUser.troopUin, true);
              if (paramView != null)
              {
                paramViewGroup = paramView;
                if (!"".equals(paramView)) {}
              }
              else
              {
                paramViewGroup = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
              }
              i1 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(str);
              if (localObject1 == null) {
                break label1134;
              }
              paramInt = ((Friends)localObject1).detalStatusFlag;
              if (localObject1 == null) {
                break label1139;
              }
              m = ((Friends)localObject1).sqqOnLineState;
              label862:
              if (localObject3 == null) {
                break label1992;
              }
              ((ImageView)localObject3).setVisibility(0);
              if (i1 != 10) {
                break label1205;
              }
              if ((paramInt != 30) && (paramInt != 31)) {
                break label1145;
              }
              ((ImageView)localObject3).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
              bool = false;
              label904:
              if (localObject2 != null) {
                a(str, ((QQMessageFacade.Message)localObject2).time);
              }
              paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str);
              if (!String.valueOf(AppConstants.Y).equals(str)) {
                break label1340;
              }
              paramViewGroup = BaseApplicationImpl.getContext().getString(2131363526);
              paramView = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
              label960:
              if (!String.valueOf(AppConstants.Z).equals(str)) {
                break label1404;
              }
              paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131363241);
              paramViewGroup = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
              if (((QQMessageFacade.Message)localObject2).senderuin == null) {
                break label1975;
              }
              localObject2 = ((QQMessageFacade.Message)localObject2).senderuin;
              if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {
                break label1376;
              }
              localObject1 = (Friends)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
              label1031:
              if ((localObject1 != null) && (((Friends)localObject1).name != null) && (((Friends)localObject1).name.length() > 0)) {
                localObject1 = ((Friends)localObject1).name;
              }
              localObject1 = paramViewGroup;
              paramViewGroup = paramView;
              paramView = (View)localObject1;
            }
            for (;;)
            {
              localView.setTag(str);
              localView.setTag(2131296439, new Object[] { Boolean.valueOf(bool) });
              localObject1 = paramView;
              paramView = paramViewGroup;
              paramViewGroup = (ViewGroup)localObject1;
              break;
              if (n != 1004) {
                break label800;
              }
              paramView = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.troopUin, str);
              break label800;
              label1134:
              paramInt = 0;
              break label850;
              label1139:
              m = 0;
              break label862;
              label1145:
              if ((paramInt == 50) || (paramInt == 51))
              {
                ((ImageView)localObject3).setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
                bool = false;
                break label904;
              }
              if (paramInt == 60)
              {
                ((ImageView)localObject3).setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
                bool = false;
                break label904;
              }
              ((ImageView)localObject3).setImageDrawable(null);
              bool = false;
              break label904;
              label1205:
              if (i1 == 11)
              {
                if ((paramInt == 30) || (paramInt == 31))
                {
                  ((ImageView)localObject3).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                  bool = false;
                  break label904;
                }
                if ((paramInt == 50) || (paramInt == 51))
                {
                  ((ImageView)localObject3).setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
                  bool = false;
                  break label904;
                }
                if (paramInt != 60) {
                  break label1992;
                }
                ((ImageView)localObject3).setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
                bool = false;
                break label904;
              }
              if ((i1 == 20) && (m == 1))
              {
                ((ImageView)localObject3).setImageDrawable(null);
                bool = false;
                break label904;
              }
              ((ImageView)localObject3).setImageDrawable(null);
              if ((n != 1001) && (n != 1000)) {
                break label1986;
              }
              bool = false;
              break label904;
              label1340:
              if (!String.valueOf(AppConstants.aa).equals(str)) {
                break label960;
              }
              paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363524);
              paramView = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
              break label960;
              label1376:
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c((String)localObject2);
              this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localObject1);
              break label1031;
              label1404:
              if (AppConstants.W.equals(str))
              {
                paramViewGroup = ((Activity)this.jdField_a_of_type_AndroidContentContext).getResources().getString(2131363532);
                paramView = this.g;
              }
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(str);
            paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(paramViewGroup, 0).getLong(paramViewGroup + str, 1L) == 0L)
            {
              if (localObject3 != null)
              {
                ((ImageView)localObject3).setVisibility(0);
                ((ImageView)localObject3).setImageResource(2130839359);
              }
              label1518:
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str);
              if (paramView == null) {
                break label1622;
              }
              localObject1 = paramView.troopname;
              paramView = paramView.troopmemo;
              label1544:
              if ((localObject1 == null) || (((String)localObject1).trim().equals(""))) {
                break label1632;
              }
            }
            for (;;)
            {
              if (((QQMessageFacade.Message)localObject2).nickName != null)
              {
                paramView = (View)localObject1;
                paramViewGroup = (ViewGroup)localObject3;
                if (!((QQMessageFacade.Message)localObject2).nickName.equals("")) {
                  break;
                }
              }
              ((QQMessageFacade.Message)localObject2).nickName = ((QQMessageFacade.Message)localObject2).senderuin;
              paramView = (View)localObject1;
              paramViewGroup = (ViewGroup)localObject3;
              break;
              if (localObject3 == null) {
                break label1518;
              }
              ((ImageView)localObject3).setImageDrawable(null);
              break label1518;
              label1622:
              localObject1 = localRecentUser.displayName;
              break label1544;
              label1632:
              localObject1 = str;
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(str);
            if ((((QQMessageFacade.Message)localObject2).nickName == null) || (((QQMessageFacade.Message)localObject2).nickName.equals(""))) {
              ((QQMessageFacade.Message)localObject2).nickName = ((QQMessageFacade.Message)localObject2).senderuin;
            }
            if (localObject3 != null) {
              ((ImageView)localObject3).setImageDrawable(null);
            }
            if (paramView == null) {
              paramView = localRecentUser.displayName;
            }
            for (;;)
            {
              if ((paramView == null) || (paramView.length() == 0))
              {
                paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363224);
                paramViewGroup = ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(str, true);
                break label477;
                paramView = paramView.discussionName;
                continue;
                if (String.valueOf(AppConstants.V).equals(str))
                {
                  paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363639);
                  paramView = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
                  localObject1 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
                  localObject1 = paramView;
                  paramView = paramViewGroup;
                  paramViewGroup = (ViewGroup)localObject1;
                  break label477;
                  if (!String.valueOf(AppConstants.U).equals(str)) {
                    break;
                  }
                  localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363618);
                  paramViewGroup = this.jdField_f_of_type_AndroidGraphicsDrawableDrawable;
                  if (localObject2 != null)
                  {
                    if ((paramView != null) && (paramView.trim().length() != 0)) {
                      break label1962;
                    }
                    paramView = ((QQMessageFacade.Message)localObject2).frienduin;
                    paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.e(paramView);
                    if ((paramView == null) || (!paramView.trim().equals(""))) {}
                  }
                  TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                  if (localRecentUser.lastmsgtime == 9223372036854775805L) {}
                  paramView = (View)localObject1;
                }
              }
            }
          }
        }
        catch (NumberFormatException paramView)
        {
          for (;;)
          {
            long l1 = 0L;
            continue;
            localImageView.setClickable(false);
            localImageView.setFocusable(false);
            localImageView.setLongClickable(false);
            continue;
            label1962:
            continue;
            paramView = null;
            paramViewGroup = null;
            continue;
            continue;
            label1975:
            localObject1 = paramView;
            paramView = paramViewGroup;
            paramViewGroup = (ViewGroup)localObject1;
            continue;
            label1986:
            boolean bool = true;
            continue;
            label1992:
            bool = false;
            continue;
            label1998:
            paramView = null;
          }
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentListAdapter
 * JD-Core Version:    0.7.0.1
 */