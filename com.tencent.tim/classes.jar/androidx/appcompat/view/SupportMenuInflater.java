package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import b.a;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportMenuInflater
  extends MenuInflater
{
  static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = { Context.class };
  static final String LOG_TAG = "SupportMenuInflater";
  static final int NO_ID = 0;
  private static final String XML_GROUP = "group";
  private static final String XML_ITEM = "item";
  private static final String XML_MENU = "menu";
  final Object[] mActionProviderConstructorArguments;
  final Object[] mActionViewConstructorArguments;
  Context mContext;
  private Object mRealOwner;
  
  public SupportMenuInflater(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mActionViewConstructorArguments = new Object[] { paramContext };
    this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
  }
  
  private Object findRealOwner(Object paramObject)
  {
    if ((paramObject instanceof Activity)) {}
    while (!(paramObject instanceof ContextWrapper)) {
      return paramObject;
    }
    return findRealOwner(((ContextWrapper)paramObject).getBaseContext());
  }
  
  private void parseMenu(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
    throws XmlPullParserException, IOException
  {
    MenuState localMenuState = new MenuState(paramMenu);
    int i = paramXmlPullParser.getEventType();
    label49:
    int k;
    int j;
    if (i == 2)
    {
      paramMenu = paramXmlPullParser.getName();
      if (paramMenu.equals("menu"))
      {
        i = paramXmlPullParser.next();
        paramMenu = null;
        int m = 0;
        k = i;
        j = 0;
        i = m;
        label65:
        if (j != 0) {
          return;
        }
      }
    }
    switch (k)
    {
    default: 
    case 2: 
    case 3: 
      for (;;)
      {
        k = paramXmlPullParser.next();
        break label65;
        throw new RuntimeException("Expecting menu, got " + paramMenu);
        j = paramXmlPullParser.next();
        i = j;
        if (j != 1) {
          break;
        }
        i = j;
        break label49;
        if (i == 0)
        {
          String str = paramXmlPullParser.getName();
          if (str.equals("group"))
          {
            localMenuState.readGroup(paramAttributeSet);
          }
          else if (str.equals("item"))
          {
            localMenuState.readItem(paramAttributeSet);
          }
          else if (str.equals("menu"))
          {
            parseMenu(paramXmlPullParser, paramAttributeSet, localMenuState.addSubMenuItem());
          }
          else
          {
            paramMenu = str;
            i = 1;
            continue;
            str = paramXmlPullParser.getName();
            if ((i != 0) && (str.equals(paramMenu)))
            {
              paramMenu = null;
              i = 0;
            }
            else if (str.equals("group"))
            {
              localMenuState.resetGroup();
            }
            else if (str.equals("item"))
            {
              if (!localMenuState.hasAddedItem()) {
                if ((localMenuState.itemActionProvider != null) && (localMenuState.itemActionProvider.hasSubMenu())) {
                  localMenuState.addSubMenuItem();
                } else {
                  localMenuState.addItem();
                }
              }
            }
            else if (str.equals("menu"))
            {
              j = 1;
            }
          }
        }
      }
    }
    throw new RuntimeException("Unexpected end of document");
  }
  
  Object getRealOwner()
  {
    if (this.mRealOwner == null) {
      this.mRealOwner = findRealOwner(this.mContext);
    }
    return this.mRealOwner;
  }
  
  /* Error */
  public void inflate(@androidx.annotation.LayoutRes int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 166
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 168	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 58	androidx/appcompat/view/SupportMenuInflater:mContext	Landroid/content/Context;
    //   26: invokevirtual 172	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 178	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore 4
    //   39: aload 6
    //   41: astore_3
    //   42: aload 6
    //   44: astore 5
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 184	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 135	androidx/appcompat/view/SupportMenuInflater:parseMenu	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull -47 -> 13
    //   63: aload 6
    //   65: invokeinterface 189 1 0
    //   70: return
    //   71: astore_2
    //   72: aload 4
    //   74: astore_3
    //   75: new 191	android/view/InflateException
    //   78: dup
    //   79: ldc 193
    //   81: aload_2
    //   82: invokespecial 196	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   85: athrow
    //   86: astore_2
    //   87: aload_3
    //   88: ifnull +9 -> 97
    //   91: aload_3
    //   92: invokeinterface 189 1 0
    //   97: aload_2
    //   98: athrow
    //   99: astore_2
    //   100: aload 5
    //   102: astore_3
    //   103: new 191	android/view/InflateException
    //   106: dup
    //   107: ldc 193
    //   109: aload_2
    //   110: invokespecial 196	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	SupportMenuInflater
    //   0	114	1	paramInt	int
    //   0	114	2	paramMenu	Menu
    //   15	88	3	localObject1	Object
    //   20	53	4	localObject2	Object
    //   17	84	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	71	org/xmlpull/v1/XmlPullParserException
    //   46	58	71	org/xmlpull/v1/XmlPullParserException
    //   22	35	86	finally
    //   46	58	86	finally
    //   75	86	86	finally
    //   103	114	86	finally
    //   22	35	99	java/io/IOException
    //   46	58	99	java/io/IOException
  }
  
  static class InflatedOnMenuItemClickListener
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] PARAM_TYPES = { MenuItem.class };
    private Method mMethod;
    private Object mRealOwner;
    
    public InflatedOnMenuItemClickListener(Object paramObject, String paramString)
    {
      this.mRealOwner = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.mMethod = localClass.getMethod(paramString, PARAM_TYPES);
        return;
      }
      catch (Exception paramObject)
      {
        paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
        paramString.initCause(paramObject);
        throw paramString;
      }
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (this.mMethod.getReturnType() == Boolean.TYPE) {
          return ((Boolean)this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem })).booleanValue();
        }
        this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  class MenuState
  {
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private int itemAlphabeticModifiers;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private CharSequence itemContentDescription;
    private boolean itemEnabled;
    private int itemIconResId;
    private ColorStateList itemIconTintList = null;
    private PorterDuff.Mode itemIconTintMode = null;
    private int itemId;
    private String itemListenerMethodName;
    private int itemNumericModifiers;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private CharSequence itemTooltipText;
    private boolean itemVisible;
    private Menu menu;
    
    public MenuState(Menu paramMenu)
    {
      this.menu = paramMenu;
      resetGroup();
    }
    
    private char getShortcut(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramArrayOfClass = Class.forName(paramString, false, SupportMenuInflater.this.mContext.getClassLoader()).getConstructor(paramArrayOfClass);
        paramArrayOfClass.setAccessible(true);
        paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
        return paramArrayOfClass;
      }
      catch (Exception paramArrayOfClass)
      {
        Log.w("SupportMenuInflater", "Cannot instantiate class: " + paramString, paramArrayOfClass);
      }
      return null;
    }
    
    private void setItem(MenuItem paramMenuItem)
    {
      int i = 1;
      Object localObject = paramMenuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
      if (this.itemCheckable >= 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
        if (this.itemShowAsAction >= 0) {
          paramMenuItem.setShowAsAction(this.itemShowAsAction);
        }
        if (this.itemListenerMethodName == null) {
          break label146;
        }
        if (!SupportMenuInflater.this.mContext.isRestricted()) {
          break;
        }
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
      paramMenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(SupportMenuInflater.this.getRealOwner(), this.itemListenerMethodName));
      label146:
      if ((paramMenuItem instanceof MenuItemImpl)) {
        localObject = (MenuItemImpl)paramMenuItem;
      }
      if (this.itemCheckable >= 2)
      {
        if ((paramMenuItem instanceof MenuItemImpl)) {
          ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(true);
        }
      }
      else
      {
        if (this.itemActionViewClassName == null) {
          break label356;
        }
        paramMenuItem.setActionView((View)newInstance(this.itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments));
      }
      for (;;)
      {
        if (this.itemActionViewLayout > 0)
        {
          if (i != 0) {
            break label344;
          }
          paramMenuItem.setActionView(this.itemActionViewLayout);
        }
        for (;;)
        {
          if (this.itemActionProvider != null) {
            MenuItemCompat.setActionProvider(paramMenuItem, this.itemActionProvider);
          }
          MenuItemCompat.setContentDescription(paramMenuItem, this.itemContentDescription);
          MenuItemCompat.setTooltipText(paramMenuItem, this.itemTooltipText);
          MenuItemCompat.setAlphabeticShortcut(paramMenuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
          MenuItemCompat.setNumericShortcut(paramMenuItem, this.itemNumericShortcut, this.itemNumericModifiers);
          if (this.itemIconTintMode != null) {
            MenuItemCompat.setIconTintMode(paramMenuItem, this.itemIconTintMode);
          }
          if (this.itemIconTintList != null) {
            MenuItemCompat.setIconTintList(paramMenuItem, this.itemIconTintList);
          }
          return;
          if (!(paramMenuItem instanceof MenuItemWrapperICS)) {
            break;
          }
          ((MenuItemWrapperICS)paramMenuItem).setExclusiveCheckable(true);
          break;
          label344:
          Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }
        label356:
        i = 0;
      }
    }
    
    public void addItem()
    {
      this.itemAdded = true;
      setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }
    
    public SubMenu addSubMenuItem()
    {
      this.itemAdded = true;
      SubMenu localSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
      setItem(localSubMenu.getItem());
      return localSubMenu;
    }
    
    public boolean hasAddedItem()
    {
      return this.itemAdded;
    }
    
    public void readGroup(AttributeSet paramAttributeSet)
    {
      paramAttributeSet = SupportMenuInflater.this.mContext.obtainStyledAttributes(paramAttributeSet, b.a.MenuGroup);
      this.groupId = paramAttributeSet.getResourceId(b.a.MenuGroup_android_id, 0);
      this.groupCategory = paramAttributeSet.getInt(b.a.MenuGroup_android_menuCategory, 0);
      this.groupOrder = paramAttributeSet.getInt(b.a.MenuGroup_android_orderInCategory, 0);
      this.groupCheckable = paramAttributeSet.getInt(b.a.MenuGroup_android_checkableBehavior, 0);
      this.groupVisible = paramAttributeSet.getBoolean(b.a.MenuGroup_android_visible, true);
      this.groupEnabled = paramAttributeSet.getBoolean(b.a.MenuGroup_android_enabled, true);
      paramAttributeSet.recycle();
    }
    
    public void readItem(AttributeSet paramAttributeSet)
    {
      int j = 1;
      paramAttributeSet = TintTypedArray.obtainStyledAttributes(SupportMenuInflater.this.mContext, paramAttributeSet, b.a.MenuItem);
      this.itemId = paramAttributeSet.getResourceId(b.a.MenuItem_android_id, 0);
      this.itemCategoryOrder = (paramAttributeSet.getInt(b.a.MenuItem_android_menuCategory, this.groupCategory) & 0xFFFF0000 | paramAttributeSet.getInt(b.a.MenuItem_android_orderInCategory, this.groupOrder) & 0xFFFF);
      this.itemTitle = paramAttributeSet.getText(b.a.MenuItem_android_title);
      this.itemTitleCondensed = paramAttributeSet.getText(b.a.MenuItem_android_titleCondensed);
      this.itemIconResId = paramAttributeSet.getResourceId(b.a.MenuItem_android_icon, 0);
      this.itemAlphabeticShortcut = getShortcut(paramAttributeSet.getString(b.a.MenuItem_android_alphabeticShortcut));
      this.itemAlphabeticModifiers = paramAttributeSet.getInt(b.a.MenuItem_alphabeticModifiers, 4096);
      this.itemNumericShortcut = getShortcut(paramAttributeSet.getString(b.a.MenuItem_android_numericShortcut));
      this.itemNumericModifiers = paramAttributeSet.getInt(b.a.MenuItem_numericModifiers, 4096);
      int i;
      if (paramAttributeSet.hasValue(b.a.MenuItem_android_checkable)) {
        if (paramAttributeSet.getBoolean(b.a.MenuItem_android_checkable, false))
        {
          i = 1;
          this.itemCheckable = i;
          label184:
          this.itemChecked = paramAttributeSet.getBoolean(b.a.MenuItem_android_checked, false);
          this.itemVisible = paramAttributeSet.getBoolean(b.a.MenuItem_android_visible, this.groupVisible);
          this.itemEnabled = paramAttributeSet.getBoolean(b.a.MenuItem_android_enabled, this.groupEnabled);
          this.itemShowAsAction = paramAttributeSet.getInt(b.a.MenuItem_showAsAction, -1);
          this.itemListenerMethodName = paramAttributeSet.getString(b.a.MenuItem_android_onClick);
          this.itemActionViewLayout = paramAttributeSet.getResourceId(b.a.MenuItem_actionLayout, 0);
          this.itemActionViewClassName = paramAttributeSet.getString(b.a.MenuItem_actionViewClass);
          this.itemActionProviderClassName = paramAttributeSet.getString(b.a.MenuItem_actionProviderClass);
          if (this.itemActionProviderClassName == null) {
            break label433;
          }
          i = j;
          label292:
          if ((i == 0) || (this.itemActionViewLayout != 0) || (this.itemActionViewClassName != null)) {
            break label438;
          }
          this.itemActionProvider = ((ActionProvider)newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionProviderConstructorArguments));
          label335:
          this.itemContentDescription = paramAttributeSet.getText(b.a.MenuItem_contentDescription);
          this.itemTooltipText = paramAttributeSet.getText(b.a.MenuItem_tooltipText);
          if (!paramAttributeSet.hasValue(b.a.MenuItem_iconTintMode)) {
            break label459;
          }
          this.itemIconTintMode = DrawableUtils.parseTintMode(paramAttributeSet.getInt(b.a.MenuItem_iconTintMode, -1), this.itemIconTintMode);
          label386:
          if (!paramAttributeSet.hasValue(b.a.MenuItem_iconTint)) {
            break label467;
          }
        }
      }
      label433:
      label438:
      label459:
      label467:
      for (this.itemIconTintList = paramAttributeSet.getColorStateList(b.a.MenuItem_iconTint);; this.itemIconTintList = null)
      {
        paramAttributeSet.recycle();
        this.itemAdded = false;
        return;
        i = 0;
        break;
        this.itemCheckable = this.groupCheckable;
        break label184;
        i = 0;
        break label292;
        if (i != 0) {
          Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        }
        this.itemActionProvider = null;
        break label335;
        this.itemIconTintMode = null;
        break label386;
      }
    }
    
    public void resetGroup()
    {
      this.groupId = 0;
      this.groupCategory = 0;
      this.groupOrder = 0;
      this.groupCheckable = 0;
      this.groupVisible = true;
      this.groupEnabled = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.view.SupportMenuInflater
 * JD-Core Version:    0.7.0.1
 */