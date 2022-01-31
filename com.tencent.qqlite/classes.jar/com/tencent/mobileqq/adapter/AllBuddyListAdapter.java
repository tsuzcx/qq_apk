package com.tencent.mobileqq.adapter;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cok;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class AllBuddyListAdapter
  extends FacePreloadBaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#";
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Comparator jdField_a_of_type_JavaUtilComparator = new cok(this);
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private char[] jdField_a_of_type_ArrayOfChar = null;
  private int[] jdField_a_of_type_ArrayOfInt = null;
  private int b;
  private int c;
  
  public AllBuddyListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    ChnToSpell.a(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.b = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    this.c = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    c();
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    Friends localFriends;
    label135:
    String str;
    label158:
    Object localObject1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903121, paramViewGroup, false);
      paramViewGroup = new BuddyListAdapter.ViewTag();
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131296453));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131296851));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131296854));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localFriends = (Friends)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangObject = localFriends;
      if (localFriends.groupid == -1007) {
        break label430;
      }
      paramViewGroup.jdField_a_of_type_JavaLangString = localFriends.uin;
      paramViewGroup.b.setImageBitmap(a(1, localFriends.uin));
      str = ContactUtils.a(localFriends);
      paramViewGroup.d.setText(str);
      if (this.jdField_a_of_type_Int == 0) {
        break label443;
      }
      localObject1 = localFriends.getRichStatus(bool);
      if (TextUtils.isEmpty(((RichStatus)localObject1).c)) {
        break label449;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject1).b, 200);
      localObject2 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2);
      paramInt = this.b;
      ((Drawable)localObject2).setBounds(0, 0, Math.round(((Drawable)localObject2).getIntrinsicWidth() * 1.0F / ((Drawable)localObject2).getIntrinsicHeight() * paramInt), paramInt);
      paramViewGroup.e.setCompoundDrawables((Drawable)localObject2, null, null, null);
      label259:
      localObject1 = ((RichStatus)localObject1).a(null);
      paramViewGroup.e.setText((CharSequence)localObject1);
      if ((!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
        break label463;
      }
      paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427517));
      label328:
      if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label486;
      }
      paramViewGroup.d.setCompoundDrawablePadding(this.c);
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839406, 0);
    }
    for (;;)
    {
      paramViewGroup = new StringBuilder(str);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramViewGroup.append("，个性签名 ，").append((CharSequence)localObject1);
      }
      paramViewGroup.append("，连按两次进入聊天界面");
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramViewGroup = (BuddyListAdapter.ViewTag)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label430:
      paramViewGroup.b.setImageResource(2130838527);
      break label135;
      label443:
      bool = false;
      break label158;
      label449:
      paramViewGroup.e.setCompoundDrawables(null, null, null, null);
      break label259;
      label463:
      paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427471));
      break label328;
      label486:
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
      {
        paramViewGroup.d.setCompoundDrawablePadding(this.c);
        paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839483, 0);
      }
      else
      {
        paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: new 285	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 286	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 33	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 289	java/util/LinkedHashMap:clear	()V
    //   16: aload_0
    //   17: getfield 57	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: bipush 43
    //   22: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   25: checkcast 291	com/tencent/mobileqq/app/FriendsManager
    //   28: invokevirtual 294	com/tencent/mobileqq/app/FriendsManager:d	()Ljava/util/ArrayList;
    //   31: astore 6
    //   33: aload 6
    //   35: invokeinterface 300 1 0
    //   40: astore 7
    //   42: aload 7
    //   44: invokeinterface 306 1 0
    //   49: ifeq +37 -> 86
    //   52: aload 7
    //   54: invokeinterface 309 1 0
    //   59: checkcast 135	com/tencent/mobileqq/data/Friends
    //   62: getfield 313	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   65: iconst_1
    //   66: if_icmpne -24 -> 42
    //   69: aload 7
    //   71: invokeinterface 316 1 0
    //   76: goto -34 -> 42
    //   79: astore 7
    //   81: aload 7
    //   83: invokevirtual 319	java/lang/Exception:printStackTrace	()V
    //   86: aload 6
    //   88: invokeinterface 300 1 0
    //   93: astore 7
    //   95: aload 7
    //   97: invokeinterface 306 1 0
    //   102: ifeq +37 -> 139
    //   105: aload 7
    //   107: invokeinterface 309 1 0
    //   112: checkcast 135	com/tencent/mobileqq/data/Friends
    //   115: getfield 313	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   118: iconst_1
    //   119: if_icmpne -24 -> 95
    //   122: aload 7
    //   124: invokeinterface 316 1 0
    //   129: goto -34 -> 95
    //   132: astore 7
    //   134: aload 7
    //   136: invokevirtual 319	java/lang/Exception:printStackTrace	()V
    //   139: aload 6
    //   141: ifnull +21 -> 162
    //   144: aload 6
    //   146: invokeinterface 322 1 0
    //   151: ifle +11 -> 162
    //   154: aload 5
    //   156: aload 6
    //   158: invokevirtual 326	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   161: pop
    //   162: aload 5
    //   164: aload_0
    //   165: getfield 46	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   168: invokestatic 332	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   171: aload 5
    //   173: invokevirtual 333	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   176: astore 5
    //   178: aload 5
    //   180: invokeinterface 306 1 0
    //   185: ifeq +149 -> 334
    //   188: aload 5
    //   190: invokeinterface 309 1 0
    //   195: checkcast 335	com/tencent/mobileqq/persistence/Entity
    //   198: astore 6
    //   200: aload 6
    //   202: checkcast 135	com/tencent/mobileqq/data/Friends
    //   205: invokestatic 158	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/data/Friends;)Ljava/lang/String;
    //   208: invokevirtual 341	java/lang/String:trim	()Ljava/lang/String;
    //   211: iconst_2
    //   212: invokestatic 344	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   215: astore 7
    //   217: aload 7
    //   219: invokevirtual 347	java/lang/String:length	()I
    //   222: ifle +88 -> 310
    //   225: aload 7
    //   227: iconst_0
    //   228: invokevirtual 351	java/lang/String:charAt	(I)C
    //   231: istore_1
    //   232: iload_1
    //   233: invokestatic 356	com/tencent/mobileqq/utils/StringUtil:c	(C)Z
    //   236: ifne +90 -> 326
    //   239: ldc 8
    //   241: ldc 8
    //   243: invokevirtual 347	java/lang/String:length	()I
    //   246: iconst_1
    //   247: isub
    //   248: invokevirtual 351	java/lang/String:charAt	(I)C
    //   251: istore_1
    //   252: aload_0
    //   253: getfield 33	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   256: iload_1
    //   257: invokestatic 362	java/lang/Character:valueOf	(C)Ljava/lang/Character;
    //   260: invokevirtual 366	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   263: ifnonnull +22 -> 285
    //   266: aload_0
    //   267: getfield 33	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   270: iload_1
    //   271: invokestatic 362	java/lang/Character:valueOf	(C)Ljava/lang/Character;
    //   274: new 285	java/util/ArrayList
    //   277: dup
    //   278: invokespecial 286	java/util/ArrayList:<init>	()V
    //   281: invokevirtual 370	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   284: pop
    //   285: aload_0
    //   286: getfield 33	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   289: iload_1
    //   290: invokestatic 362	java/lang/Character:valueOf	(C)Ljava/lang/Character;
    //   293: invokevirtual 366	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   296: checkcast 296	java/util/List
    //   299: aload 6
    //   301: invokeinterface 374 2 0
    //   306: pop
    //   307: goto -129 -> 178
    //   310: ldc 8
    //   312: ldc 8
    //   314: invokevirtual 347	java/lang/String:length	()I
    //   317: iconst_1
    //   318: isub
    //   319: invokevirtual 351	java/lang/String:charAt	(I)C
    //   322: istore_1
    //   323: goto -91 -> 232
    //   326: iload_1
    //   327: invokestatic 378	java/lang/Character:toUpperCase	(C)C
    //   330: istore_1
    //   331: goto -79 -> 252
    //   334: aload_0
    //   335: getfield 33	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   338: invokevirtual 382	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   341: astore 5
    //   343: aload_0
    //   344: aload 5
    //   346: invokeinterface 385 1 0
    //   351: iconst_1
    //   352: iadd
    //   353: newarray int
    //   355: putfield 35	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_ArrayOfInt	[I
    //   358: aload_0
    //   359: aload 5
    //   361: invokeinterface 385 1 0
    //   366: newarray char
    //   368: putfield 37	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_ArrayOfChar	[C
    //   371: aload_0
    //   372: getfield 33	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   375: invokevirtual 382	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   378: invokeinterface 386 1 0
    //   383: astore 5
    //   385: aload_0
    //   386: getfield 35	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_ArrayOfInt	[I
    //   389: iconst_0
    //   390: iconst_0
    //   391: iastore
    //   392: iconst_1
    //   393: istore_2
    //   394: iload_2
    //   395: aload_0
    //   396: getfield 35	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_ArrayOfInt	[I
    //   399: arraylength
    //   400: if_icmpge +62 -> 462
    //   403: aload_0
    //   404: getfield 35	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_ArrayOfInt	[I
    //   407: astore 6
    //   409: aload 6
    //   411: iload_2
    //   412: iaload
    //   413: istore_3
    //   414: aload_0
    //   415: getfield 35	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_ArrayOfInt	[I
    //   418: iload_2
    //   419: iconst_1
    //   420: isub
    //   421: iaload
    //   422: istore 4
    //   424: aload 6
    //   426: iload_2
    //   427: aload_0
    //   428: getfield 33	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   431: aload 5
    //   433: invokeinterface 309 1 0
    //   438: invokevirtual 366	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   441: checkcast 296	java/util/List
    //   444: invokeinterface 322 1 0
    //   449: iload 4
    //   451: iadd
    //   452: iload_3
    //   453: iadd
    //   454: iastore
    //   455: iload_2
    //   456: iconst_1
    //   457: iadd
    //   458: istore_2
    //   459: goto -65 -> 394
    //   462: aload_0
    //   463: getfield 33	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   466: invokevirtual 382	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   469: invokeinterface 386 1 0
    //   474: astore 5
    //   476: iconst_0
    //   477: istore_2
    //   478: aload 5
    //   480: invokeinterface 306 1 0
    //   485: ifeq +29 -> 514
    //   488: aload_0
    //   489: getfield 37	com/tencent/mobileqq/adapter/AllBuddyListAdapter:jdField_a_of_type_ArrayOfChar	[C
    //   492: iload_2
    //   493: aload 5
    //   495: invokeinterface 309 1 0
    //   500: checkcast 358	java/lang/Character
    //   503: invokevirtual 390	java/lang/Character:charValue	()C
    //   506: castore
    //   507: iload_2
    //   508: iconst_1
    //   509: iadd
    //   510: istore_2
    //   511: goto -33 -> 478
    //   514: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	515	0	this	AllBuddyListAdapter
    //   231	100	1	c1	char
    //   393	118	2	i	int
    //   413	41	3	j	int
    //   422	30	4	k	int
    //   7	487	5	localObject1	Object
    //   31	394	6	localObject2	Object
    //   40	30	7	localIterator1	java.util.Iterator
    //   79	3	7	localException1	java.lang.Exception
    //   93	30	7	localIterator2	java.util.Iterator
    //   132	3	7	localException2	java.lang.Exception
    //   215	11	7	str	String
    // Exception table:
    //   from	to	target	type
    //   33	42	79	java/lang/Exception
    //   42	76	79	java/lang/Exception
    //   86	95	132	java/lang/Exception
    //   95	129	132	java/lang/Exception
  }
  
  public int a(char paramChar)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfChar.length) {
      if (paramChar != this.jdField_a_of_type_ArrayOfChar[i]) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      i = -1;
    }
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = ((Friends)getItem(paramInt)).uin;
    return localFaceInfo;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int k = this.b;
      int i = 0;
      if (i < j)
      {
        BuddyListAdapter.ViewTag localViewTag = (BuddyListAdapter.ViewTag)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
        Object localObject1;
        if ((localViewTag != null) && (localViewTag.jdField_a_of_type_JavaLangString != null) && (localViewTag.jdField_a_of_type_JavaLangString.length() > 0))
        {
          localObject1 = ((Friends)localViewTag.jdField_a_of_type_JavaLangObject).getRichStatus(false);
          if (TextUtils.isEmpty(((RichStatus)localObject1).c)) {
            break label201;
          }
          Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject1).b, 200);
          localObject2 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2);
          ((Drawable)localObject2).setBounds(0, 0, Math.round(((Drawable)localObject2).getIntrinsicWidth() * 1.0F / ((Drawable)localObject2).getIntrinsicHeight() * k), k);
          localViewTag.e.setCompoundDrawables((Drawable)localObject2, null, null, null);
        }
        for (;;)
        {
          localObject1 = ((RichStatus)localObject1).a(null);
          localViewTag.e.setText((CharSequence)localObject1);
          i += 1;
          break;
          label201:
          localViewTag.e.setCompoundDrawables(null, null, null, null);
        }
      }
    }
    super.a(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      return this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return (Entity)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(this.jdField_a_of_type_ArrayOfChar[i]))).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i]);
    }
    i = -(i + 1) - 1;
    return (Entity)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(this.jdField_a_of_type_ArrayOfChar[i]))).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i]);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void notifyDataSetChanged()
  {
    c();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AllBuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */