package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ResourceCursorTreeAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQServiceEntry;
import com.tencent.mobileqq.app.QQServiceEntry.Tag;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import eyc;
import eyd;
import eye;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForwardFriendListAdapter
  extends ResourceCursorTreeAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static final String a = "status,sqqtype desc,name asc";
  public static int e = 0;
  private static final int jdField_f_of_type_Int = 50;
  private static final int jdField_g_of_type_Int = 52;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  public final Activity a;
  private Cursor jdField_a_of_type_AndroidDatabaseCursor;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Message jdField_a_of_type_AndroidOsMessage;
  ExpandableListView jdField_a_of_type_AndroidWidgetExpandableListView;
  public QQAppInterface a;
  private QQServiceEntry jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private eye jdField_a_of_type_Eye;
  private List jdField_a_of_type_JavaUtilList;
  public Map a;
  private Set jdField_a_of_type_JavaUtilSet;
  boolean jdField_a_of_type_Boolean;
  public int b;
  private BitmapDrawable jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private final String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  public Map b;
  private Set jdField_b_of_type_JavaUtilSet;
  private boolean jdField_b_of_type_Boolean = false;
  public int c;
  private Drawable c;
  int jdField_d_of_type_Int;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private Drawable e;
  private Drawable jdField_f_of_type_AndroidGraphicsDrawableDrawable;
  private Drawable jdField_g_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_h_of_type_Int;
  private Drawable jdField_h_of_type_AndroidGraphicsDrawableDrawable;
  private int i;
  
  static
  {
    jdField_e_of_type_Int = 0;
  }
  
  public ForwardFriendListAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, QQServiceEntry paramQQServiceEntry, Cursor paramCursor, int paramInt1, int paramInt2, Message paramMessage, boolean paramBoolean)
  {
    super(paramActivity, paramCursor, paramInt1, paramInt2);
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry = paramQQServiceEntry;
    this.jdField_a_of_type_AndroidOsMessage = paramMessage;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_Eye = new eye(this, paramActivity);
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b();
    this.jdField_a_of_type_Float = paramActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramActivity.getResources().getDrawable(2130840228);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramActivity.getResources().getDrawable(2130840232);
    this.c = paramActivity.getResources().getDrawable(2130840222);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramActivity.getResources().getDrawable(2130840233);
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = paramActivity.getResources().getDrawable(2130838009);
    this.g = paramActivity.getResources().getDrawable(2130838082);
    this.h = paramActivity.getResources().getDrawable(2130838083);
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
  }
  
  private void a(String paramString, int paramInt, ImageView paramImageView)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString);
    if (localBitmap == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 1, false);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
      }
      paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
  }
  
  private static HashMap b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", Integer.valueOf(0));
    localHashMap.put("remark", Integer.valueOf(1));
    localHashMap.put("uin", Integer.valueOf(2));
    localHashMap.put("signature", Integer.valueOf(3));
    localHashMap.put("status", Integer.valueOf(4));
    localHashMap.put("isMqqOnLine", Integer.valueOf(5));
    localHashMap.put("sqqtype", Integer.valueOf(6));
    localHashMap.put("alias", Integer.valueOf(7));
    localHashMap.put("sqqOnLineState", Integer.valueOf(8));
    localHashMap.put("detalStatusFlag", Integer.valueOf(9));
    localHashMap.put("faceid", Integer.valueOf(10));
    localHashMap.put("_id", Integer.valueOf(100));
    return localHashMap;
  }
  
  private void b()
  {
    int j = 0;
    if (j < getGroupCount())
    {
      int k = (int)getGroupId(j);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Eye.onQueryComplete(k, null, eyd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k));
      }
      for (;;)
      {
        j += 1;
        break;
        this.jdField_a_of_type_Eye.startQuery(k, null, Uri.parse("content://qqi.friendlist/friendlist/" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), null, "groupid=?", new String[] { String.valueOf(k) }, "status,sqqtype desc,name asc");
      }
    }
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
    return DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230).setTitle(str).setItems(2131689474, new eyc(this, paramString2));
  }
  
  public List a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(this.jdField_d_of_type_Int, null);
    if ((localObject1 instanceof ViewGroup)) {
      ((ViewGroup)localObject1).getChildCount();
    }
    if (this.jdField_a_of_type_AndroidWidgetExpandableListView != null)
    {
      paramInt2 = this.jdField_a_of_type_AndroidWidgetExpandableListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetExpandableListView.getChildAt(paramInt1);
        if (localObject1 != null)
        {
          Object localObject2 = ((View)localObject1).getTag();
          if ((localObject2 != null) && ((localObject2 instanceof String)) && (paramString != null) && (localObject2.equals(paramString)))
          {
            localObject1 = (ImageView)((View)localObject1).findViewById(2131230940);
            if ((localObject1 != null) && (paramBitmap != null)) {
              ((ImageView)localObject1).setImageBitmap(paramBitmap);
            }
          }
        }
      }
      else
      {
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public void a(ListView paramListView)
  {
    if ((paramListView != null) && ((paramListView instanceof ExpandableListView))) {
      this.jdField_a_of_type_AndroidWidgetExpandableListView = ((ExpandableListView)paramListView);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(String paramString, View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131230940);
    boolean bool = ((Boolean)((Object[])(Object[])paramView.getTag(2131230985))[0]).booleanValue();
    localImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, bool));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void bindChildView(View paramView, Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    System.currentTimeMillis();
    if (paramCursor.isClosed()) {
      return;
    }
    String str3 = paramCursor.getString(paramCursor.getColumnIndex("name"));
    String str1 = paramCursor.getString(paramCursor.getColumnIndex("remark"));
    String str2 = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    int k = paramCursor.getInt(paramCursor.getColumnIndex("status"));
    System.currentTimeMillis();
    Object localObject = (TextView)paramView.findViewById(2131231395);
    TextView localTextView = (TextView)paramView.findViewById(2131231396);
    label158:
    int j;
    label211:
    int m;
    int n;
    boolean bool;
    if (paramCursor.getInt(paramCursor.getColumnIndex("sqqtype")) > 0)
    {
      ((TextView)localObject).setTextColor(paramContext.getResources().getColor(2131361830));
      if ((str1 == null) || (str1.length() <= 0)) {
        break label428;
      }
      ((TextView)localObject).setText(str1);
      j = paramCursor.getColumnIndex("signature");
      if (localTextView != null) {
        localTextView.setText(paramCursor.getString(j));
      }
      System.currentTimeMillis();
      if (paramCursor.getInt(paramCursor.getColumnIndex("isMqqOnLine")) != 1) {
        break label505;
      }
      j = 1;
      m = paramCursor.getInt(paramCursor.getColumnIndex("sqqOnLineState"));
      n = paramCursor.getInt(paramCursor.getColumnIndex("detalStatusFlag"));
      paramContext = (ImageView)paramView.findViewById(2131231394);
      bool = false;
      paramBoolean = bool;
      if (paramContext != null)
      {
        if (k != 10) {
          break label594;
        }
        if ((n != 30) && (n != 31)) {
          break label511;
        }
        paramContext.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramBoolean = bool;
      }
    }
    label428:
    label594:
    for (;;)
    {
      System.currentTimeMillis();
      localObject = (ImageView)paramView.findViewById(2131230940);
      paramCursor = (QQServiceEntry.Tag)((ImageView)localObject).getTag();
      paramContext = paramCursor;
      if (paramCursor == null) {
        paramContext = new QQServiceEntry.Tag();
      }
      paramContext.jdField_a_of_type_JavaLangString = str2;
      paramContext.jdField_b_of_type_JavaLangString = str1;
      paramContext.jdField_a_of_type_Int = 0;
      paramContext.jdField_b_of_type_Int = 13;
      paramView.setTag(str2);
      ((ImageView)localObject).setTag(paramContext);
      ((ImageView)localObject).setClickable(false);
      ((ImageView)localObject).setLongClickable(false);
      paramView.setTag(2131230985, new Object[] { Boolean.valueOf(paramBoolean) });
      a(str2, 0, (ImageView)localObject);
      System.currentTimeMillis();
      return;
      ((TextView)localObject).setTextColor(-16777216);
      break;
      if ((str3 != null) && (!"".equals(str3)))
      {
        ((TextView)localObject).setText(str3);
        break label158;
      }
      paramContext = paramCursor.getString(paramCursor.getColumnIndex("alias"));
      if ((paramContext != null) && (!"".equals(paramContext.trim())))
      {
        ((TextView)localObject).setText(paramContext);
        break label158;
      }
      ((TextView)localObject).setText(str2);
      break label158;
      label505:
      j = 0;
      break label211;
      label511:
      if ((n == 50) || (n == 51))
      {
        paramContext.setImageDrawable(this.c);
        paramBoolean = bool;
      }
      else if (n == 60)
      {
        paramContext.setImageDrawable(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
        paramBoolean = bool;
      }
      else if (j != 0)
      {
        paramContext.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        paramBoolean = bool;
      }
      else
      {
        paramContext.setImageDrawable(null);
        paramBoolean = bool;
        continue;
        if (k == 11)
        {
          if ((n == 30) || (n == 31))
          {
            paramContext.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            paramBoolean = bool;
          }
          else if ((n == 50) || (n == 51))
          {
            paramContext.setImageDrawable(this.c);
            paramBoolean = bool;
          }
          else if (n == 60)
          {
            paramContext.setImageDrawable(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
            paramBoolean = bool;
          }
          else
          {
            paramContext.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
            paramBoolean = bool;
          }
        }
        else if ((k == 20) && (m == 1))
        {
          paramContext.setImageDrawable(null);
          paramBoolean = bool;
        }
        else
        {
          paramContext.setImageDrawable(null);
          paramBoolean = true;
        }
      }
    }
  }
  
  protected void bindGroupView(View paramView, Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    if (paramCursor.isClosed()) {
      return;
    }
    int j = paramCursor.getInt(3);
    ForwardFriendListAdapter.SetGroupInfo localSetGroupInfo = (ForwardFriendListAdapter.SetGroupInfo)paramView.getTag();
    paramContext = localSetGroupInfo;
    if (localSetGroupInfo == null)
    {
      paramContext = new ForwardFriendListAdapter.SetGroupInfo();
      paramView.setTag(paramContext);
    }
    paramContext.jdField_a_of_type_JavaLangString = paramCursor.getString(0);
    paramContext.jdField_a_of_type_Int = j;
    paramContext.jdField_b_of_type_Int = paramCursor.getInt(4);
    if (paramCursor.isLast()) {
      if ((paramCursor.getInt(2) > 0) && (paramBoolean))
      {
        paramView.setBackgroundResource(2130837849);
        paramView.getLayoutParams().height = ((int)(this.jdField_a_of_type_Float * 50.0F));
        paramContext = (TextView)paramView.findViewById(2131231389);
        LocaleString.a(paramCursor.getString(0), paramContext);
        paramView = (TextView)paramView.findViewById(2131231390);
        if (this.jdField_a_of_type_JavaUtilMap == null) {
          break label256;
        }
        paramContext = (Cursor)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
        if (paramContext == null) {
          break label256;
        }
      }
    }
    label256:
    for (j = paramContext.getCount();; j = 0)
    {
      paramView.setText(String.valueOf(j));
      return;
      paramView.getLayoutParams().height = ((int)(52.0F * this.jdField_a_of_type_Float));
      paramView.setBackgroundResource(2130837849);
      break;
      paramView.setBackgroundResource(2130837849);
      paramView.getLayoutParams().height = ((int)(this.jdField_a_of_type_Float * 50.0F));
      break;
    }
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = (Cursor)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localObject == null) {}
    while (((Cursor)localObject).isClosed()) {
      return 0L;
    }
    if (((Cursor)localObject).moveToPosition(paramInt2))
    {
      localObject = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("uin"));
      if ((localObject == null) || ("".equals(localObject))) {}
    }
    for (;;)
    {
      try
      {
        l = Long.valueOf((String)localObject).longValue();
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l = 0L;
        continue;
      }
      long l = 0L;
    }
  }
  
  protected Cursor getChildrenCursor(Cursor paramCursor)
  {
    return null;
  }
  
  public long getGroupId(int paramInt)
  {
    Cursor localCursor = getCursor();
    int j = 0;
    if (localCursor.moveToPosition(paramInt)) {
      j = localCursor.getInt(localCursor.getColumnIndex("group_id"));
    }
    return j;
  }
  
  public void onGroupCollapsed(int paramInt) {}
  
  public void setChildrenCursor(int paramInt, Cursor paramCursor)
  {
    super.onGroupCollapsed(paramInt);
    super.setChildrenCursor(paramInt, paramCursor);
  }
  
  public void setGroupCursor(Cursor paramCursor)
  {
    super.setGroupCursor(paramCursor);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardFriendListAdapter
 * JD-Core Version:    0.7.0.1
 */