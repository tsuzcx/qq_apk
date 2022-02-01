package com.tencent.token;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

public final class ja
  extends fx
  implements View.OnClickListener
{
  public int j = 1;
  private final SearchManager k = (SearchManager)this.d.getSystemService("search");
  private final SearchView l;
  private final SearchableInfo m;
  private final Context n;
  private final WeakHashMap<String, Drawable.ConstantState> o;
  private final int p;
  private boolean q = false;
  private ColorStateList r;
  private int s = -1;
  private int t = -1;
  private int u = -1;
  private int v = -1;
  private int w = -1;
  private int x = -1;
  
  public ja(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout());
    this.l = paramSearchView;
    this.m = paramSearchableInfo;
    this.p = paramSearchView.getSuggestionCommitIconResId();
    this.n = paramContext;
    this.o = paramWeakHashMap;
  }
  
  private Drawable a(ComponentName paramComponentName)
  {
    Object localObject = this.d.getPackageManager();
    try
    {
      ActivityInfo localActivityInfo = ((PackageManager)localObject).getActivityInfo(paramComponentName, 128);
      int i = localActivityInfo.getIconResource();
      if (i == 0) {
        return null;
      }
      localObject = ((PackageManager)localObject).getDrawable(paramComponentName.getPackageName(), i, localActivityInfo.applicationInfo);
      if (localObject == null)
      {
        localObject = new StringBuilder("Invalid icon resource ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" for ");
        ((StringBuilder)localObject).append(paramComponentName.flattenToShortString());
        return null;
      }
      return localObject;
    }
    catch (PackageManager.NameNotFoundException paramComponentName) {}
    return null;
  }
  
  private Drawable a(Uri paramUri)
  {
    try
    {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      if (!bool) {}
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject1;
      label22:
      Drawable localDrawable;
      label69:
      label95:
      localStringBuilder = new StringBuilder("Icon not found: ");
      localStringBuilder.append(paramUri);
      localStringBuilder.append(", ");
      localStringBuilder.append(localFileNotFoundException.getMessage());
      return null;
    }
    try
    {
      localObject1 = b(paramUri);
      return localObject1;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      break label22;
    }
    throw new FileNotFoundException("Resource does not exist: ".concat(String.valueOf(paramUri)));
    localObject1 = this.n.getContentResolver().openInputStream(paramUri);
    if (localObject1 != null) {
      try
      {
        localDrawable = Drawable.createFromStream((InputStream)localObject1, null);
      }
      finally {}
    }
    try
    {
      ((InputStream)localObject1).close();
      return localDrawable;
    }
    catch (IOException localIOException1)
    {
      break label69;
    }
    new StringBuilder("Error closing icon stream for ").append(paramUri);
    return localDrawable;
    try
    {
      ((InputStream)localObject1).close();
    }
    catch (IOException localIOException2)
    {
      StringBuilder localStringBuilder;
      break label95;
    }
    new StringBuilder("Error closing icon stream for ").append(paramUri);
    throw localObject2;
    throw new FileNotFoundException("Failed to open ".concat(String.valueOf(paramUri)));
  }
  
  private Drawable a(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      if ("0".equals(paramString)) {
        return null;
      }
    }
    try
    {
      int i = Integer.parseInt(paramString);
      localObject = new StringBuilder("android.resource://");
      ((StringBuilder)localObject).append(this.n.getPackageName());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      Drawable localDrawable = b((String)localObject);
      if (localDrawable != null) {
        return localDrawable;
      }
      localDrawable = cs.a(this.n, i);
      a((String)localObject, localDrawable);
      return localDrawable;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Object localObject;
      label102:
      break label102;
    }
    catch (Resources.NotFoundException paramString) {}
    localObject = b(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = a(Uri.parse(paramString));
    a(paramString, (Drawable)localObject);
    return localObject;
    return null;
    return null;
  }
  
  private static String a(Cursor paramCursor, int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      return paramCursor;
    }
    catch (Exception paramCursor) {}
    return null;
  }
  
  public static String a(Cursor paramCursor, String paramString)
  {
    return a(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private static void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
      return;
    }
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private static void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.o.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private Drawable b(Uri paramUri)
  {
    String str = paramUri.getAuthority();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      localResources = this.d.getPackageManager().getResourcesForApplication(str);
      localList = paramUri.getPathSegments();
      if (localList != null)
      {
        i = localList.size();
        if (i != 1) {}
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Resources localResources;
      List localList;
      int i;
      label67:
      break label184;
    }
    try
    {
      i = Integer.parseInt((String)localList.get(0));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label67;
    }
    throw new FileNotFoundException("Single path segment is not a resource ID: ".concat(String.valueOf(paramUri)));
    if (i == 2)
    {
      i = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), str);
      if (i != 0) {
        return localResources.getDrawable(i);
      }
      throw new FileNotFoundException("No resource found for: ".concat(String.valueOf(paramUri)));
    }
    throw new FileNotFoundException("More than two path segments: ".concat(String.valueOf(paramUri)));
    throw new FileNotFoundException("No path: ".concat(String.valueOf(paramUri)));
    label184:
    throw new FileNotFoundException("No package found for authority: ".concat(String.valueOf(paramUri)));
    throw new FileNotFoundException("No authority: ".concat(String.valueOf(paramUri)));
  }
  
  private Drawable b(String paramString)
  {
    paramString = (Drawable.ConstantState)this.o.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.newDrawable();
  }
  
  private static void c(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor = paramCursor.getExtras();
    } else {
      paramCursor = null;
    }
    if ((paramCursor != null) && (paramCursor.getBoolean("in_progress"))) {}
  }
  
  public final Cursor a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    } else {
      paramCharSequence = paramCharSequence.toString();
    }
    if (this.l.getVisibility() == 0) {
      if (this.l.getWindowVisibility() != 0) {
        return null;
      }
    }
    try
    {
      Object localObject2 = this.m;
      if (localObject2 == null)
      {
        paramCharSequence = null;
      }
      else
      {
        Object localObject1 = ((SearchableInfo)localObject2).getSuggestAuthority();
        if (localObject1 == null)
        {
          paramCharSequence = null;
        }
        else
        {
          localObject1 = new Uri.Builder().scheme("content").authority((String)localObject1).query("").fragment("");
          String str = ((SearchableInfo)localObject2).getSuggestPath();
          if (str != null) {
            ((Uri.Builder)localObject1).appendEncodedPath(str);
          }
          ((Uri.Builder)localObject1).appendPath("search_suggest_query");
          localObject2 = ((SearchableInfo)localObject2).getSuggestSelection();
          if (localObject2 != null)
          {
            paramCharSequence = new String[] { paramCharSequence };
          }
          else
          {
            ((Uri.Builder)localObject1).appendPath(paramCharSequence);
            paramCharSequence = null;
          }
          ((Uri.Builder)localObject1).appendQueryParameter("limit", "50");
          localObject1 = ((Uri.Builder)localObject1).build();
          paramCharSequence = this.d.getContentResolver().query((Uri)localObject1, null, (String)localObject2, paramCharSequence, null);
        }
      }
      if (paramCharSequence != null)
      {
        paramCharSequence.getCount();
        return paramCharSequence;
      }
      return null;
    }
    catch (RuntimeException paramCharSequence) {}
    return null;
    return null;
  }
  
  public final View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = super.a(paramContext, paramCursor, paramViewGroup);
    paramContext.setTag(new a(paramContext));
    ((ImageView)paramContext.findViewById(gp.f.edit_query)).setImageResource(this.p);
    return paramContext;
  }
  
  public final void a(Cursor paramCursor)
  {
    if (this.q)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
    }
    try
    {
      super.a(paramCursor);
      if (paramCursor != null)
      {
        this.s = paramCursor.getColumnIndex("suggest_text_1");
        this.t = paramCursor.getColumnIndex("suggest_text_2");
        this.u = paramCursor.getColumnIndex("suggest_text_2_url");
        this.v = paramCursor.getColumnIndex("suggest_icon_1");
        this.w = paramCursor.getColumnIndex("suggest_icon_2");
        this.x = paramCursor.getColumnIndex("suggest_flags");
      }
      return;
    }
    catch (Exception paramCursor) {}
  }
  
  public final void a(View paramView, Cursor paramCursor)
  {
    a locala = (a)paramView.getTag();
    int i = this.x;
    if (i != -1) {
      i = paramCursor.getInt(i);
    } else {
      i = 0;
    }
    if (locala.a != null)
    {
      paramView = a(paramCursor, this.s);
      a(locala.a, paramView);
    }
    if (locala.b != null)
    {
      str1 = a(paramCursor, this.u);
      if (str1 != null)
      {
        if (this.r == null)
        {
          paramView = new TypedValue();
          this.d.getTheme().resolveAttribute(gp.a.textColorSearchUrl, paramView, true);
          this.r = this.d.getResources().getColorStateList(paramView.resourceId);
        }
        paramView = new SpannableString(str1);
        paramView.setSpan(new TextAppearanceSpan(null, 0, 0, this.r, null), 0, str1.length(), 33);
      }
      else
      {
        paramView = a(paramCursor, this.t);
      }
      if (TextUtils.isEmpty(paramView))
      {
        if (locala.a != null)
        {
          locala.a.setSingleLine(false);
          locala.a.setMaxLines(2);
        }
      }
      else if (locala.a != null)
      {
        locala.a.setSingleLine(true);
        locala.a.setMaxLines(1);
      }
      a(locala.b, paramView);
    }
    paramView = locala.c;
    String str1 = null;
    Object localObject;
    if (paramView != null)
    {
      ImageView localImageView = locala.c;
      i1 = this.v;
      if (i1 == -1)
      {
        paramView = null;
      }
      else
      {
        paramView = a(paramCursor.getString(i1));
        if (paramView == null)
        {
          paramView = this.m.getSearchActivity();
          String str2 = paramView.flattenToShortString();
          if (this.o.containsKey(str2))
          {
            paramView = (Drawable.ConstantState)this.o.get(str2);
            if (paramView == null) {
              paramView = null;
            } else {
              paramView = paramView.newDrawable(this.n.getResources());
            }
          }
          else
          {
            localObject = a(paramView);
            if (localObject == null) {
              paramView = null;
            } else {
              paramView = ((Drawable)localObject).getConstantState();
            }
            this.o.put(str2, paramView);
            paramView = (View)localObject;
          }
          if (paramView == null) {
            paramView = this.d.getPackageManager().getDefaultActivityIcon();
          }
        }
      }
      a(localImageView, paramView, 4);
    }
    if (locala.d != null)
    {
      localObject = locala.d;
      i1 = this.w;
      if (i1 == -1) {
        paramView = str1;
      } else {
        paramView = a(paramCursor.getString(i1));
      }
      a((ImageView)localObject, paramView, 8);
    }
    int i1 = this.j;
    if ((i1 != 2) && ((i1 != 1) || ((i & 0x1) == 0)))
    {
      locala.e.setVisibility(8);
      return;
    }
    locala.e.setVisibility(0);
    locala.e.setTag(locala.a.getText());
    locala.e.setOnClickListener(this);
  }
  
  public final CharSequence b(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    String str = a(paramCursor, "suggest_intent_query");
    if (str != null) {
      return str;
    }
    if (this.m.shouldRewriteQueryFromData())
    {
      str = a(paramCursor, "suggest_intent_data");
      if (str != null) {
        return str;
      }
    }
    if (this.m.shouldRewriteQueryFromText())
    {
      paramCursor = a(paramCursor, "suggest_text_1");
      if (paramCursor != null) {
        return paramCursor;
      }
    }
    return null;
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      paramViewGroup = b(this.d, this.c, paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).a.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      paramViewGroup = a(this.d, this.c, paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).a.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public final boolean hasStableIds()
  {
    return false;
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    c(a());
  }
  
  public final void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    c(a());
  }
  
  public final void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      this.l.setQuery((CharSequence)paramView);
    }
  }
  
  static final class a
  {
    public final TextView a;
    public final TextView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    
    public a(View paramView)
    {
      this.a = ((TextView)paramView.findViewById(16908308));
      this.b = ((TextView)paramView.findViewById(16908309));
      this.c = ((ImageView)paramView.findViewById(16908295));
      this.d = ((ImageView)paramView.findViewById(16908296));
      this.e = ((ImageView)paramView.findViewById(gp.f.edit_query));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ja
 * JD-Core Version:    0.7.0.1
 */