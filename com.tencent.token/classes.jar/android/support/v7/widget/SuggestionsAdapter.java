package android.support.v7.widget;

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
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
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

class SuggestionsAdapter
  extends ResourceCursorAdapter
  implements View.OnClickListener
{
  private static final boolean DBG = false;
  static final int INVALID_INDEX = -1;
  private static final String LOG_TAG = "SuggestionsAdapter";
  private static final int QUERY_LIMIT = 50;
  static final int REFINE_ALL = 2;
  static final int REFINE_BY_ENTRY = 1;
  static final int REFINE_NONE = 0;
  private boolean mClosed = false;
  private final int mCommitIconResId;
  private int mFlagsCol = -1;
  private int mIconName1Col = -1;
  private int mIconName2Col = -1;
  private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
  private final Context mProviderContext;
  private int mQueryRefinement = 1;
  private final SearchManager mSearchManager = (SearchManager)this.mContext.getSystemService("search");
  private final SearchView mSearchView;
  private final SearchableInfo mSearchable;
  private int mText1Col = -1;
  private int mText2Col = -1;
  private int mText2UrlCol = -1;
  private ColorStateList mUrlColor;
  
  public SuggestionsAdapter(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    this.mSearchView = paramSearchView;
    this.mSearchable = paramSearchableInfo;
    this.mCommitIconResId = paramSearchView.getSuggestionCommitIconResId();
    this.mProviderContext = paramContext;
    this.mOutsideDrawablesCache = paramWeakHashMap;
  }
  
  private Drawable checkIconCache(String paramString)
  {
    paramString = (Drawable.ConstantState)this.mOutsideDrawablesCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.newDrawable();
  }
  
  private CharSequence formatUrl(CharSequence paramCharSequence)
  {
    if (this.mUrlColor == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, (TypedValue)localObject, true);
      this.mUrlColor = this.mContext.getResources().getColorStateList(((TypedValue)localObject).resourceId);
    }
    Object localObject = new SpannableString(paramCharSequence);
    ((SpannableString)localObject).setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, paramCharSequence.length(), 33);
    return localObject;
  }
  
  private Drawable getActivityIcon(ComponentName paramComponentName)
  {
    Object localObject = this.mContext.getPackageManager();
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid icon resource ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" for ");
        ((StringBuilder)localObject).append(paramComponentName.flattenToShortString());
        Log.w("SuggestionsAdapter", ((StringBuilder)localObject).toString());
        return null;
      }
      return localObject;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      Log.w("SuggestionsAdapter", paramComponentName.toString());
    }
    return null;
  }
  
  private Drawable getActivityIconWithCache(ComponentName paramComponentName)
  {
    String str = paramComponentName.flattenToShortString();
    boolean bool = this.mOutsideDrawablesCache.containsKey(str);
    Object localObject = null;
    if (bool)
    {
      paramComponentName = (Drawable.ConstantState)this.mOutsideDrawablesCache.get(str);
      if (paramComponentName == null) {
        return null;
      }
      return paramComponentName.newDrawable(this.mProviderContext.getResources());
    }
    Drawable localDrawable = getActivityIcon(paramComponentName);
    if (localDrawable == null) {
      paramComponentName = localObject;
    } else {
      paramComponentName = localDrawable.getConstantState();
    }
    this.mOutsideDrawablesCache.put(str, paramComponentName);
    return localDrawable;
  }
  
  public static String getColumnString(Cursor paramCursor, String paramString)
  {
    return getStringOrNull(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private Drawable getDefaultIcon1(Cursor paramCursor)
  {
    paramCursor = getActivityIconWithCache(this.mSearchable.getSearchActivity());
    if (paramCursor != null) {
      return paramCursor;
    }
    return this.mContext.getPackageManager().getDefaultActivityIcon();
  }
  
  private Drawable getDrawable(Uri paramUri)
  {
    try
    {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      if (!bool) {}
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject1;
      label23:
      InputStream localInputStream;
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Icon not found: ");
      localStringBuilder2.append(paramUri);
      localStringBuilder2.append(", ");
      localStringBuilder2.append(localFileNotFoundException.getMessage());
      Log.w("SuggestionsAdapter", localStringBuilder2.toString());
      return null;
    }
    try
    {
      localObject1 = getDrawableFromResourceUri(paramUri);
      return localObject1;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      break label23;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Resource does not exist: ");
    ((StringBuilder)localObject1).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject1).toString());
    localInputStream = this.mProviderContext.getContentResolver().openInputStream(paramUri);
    if (localInputStream != null) {
      try
      {
        localObject1 = Drawable.createFromStream(localInputStream, null);
        StringBuilder localStringBuilder3;
        try
        {
          localInputStream.close();
          return localObject1;
        }
        catch (IOException localIOException1)
        {
          localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("Error closing icon stream for ");
          localStringBuilder3.append(paramUri);
          Log.e("SuggestionsAdapter", localStringBuilder3.toString(), localIOException1);
          return localObject1;
        }
        localStringBuilder1 = new StringBuilder();
      }
      finally
      {
        try
        {
          localIOException1.close();
        }
        catch (IOException localIOException2)
        {
          localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("Error closing icon stream for ");
          localStringBuilder3.append(paramUri);
          Log.e("SuggestionsAdapter", localStringBuilder3.toString(), localIOException2);
        }
      }
    }
    localStringBuilder1.append("Failed to open ");
    localStringBuilder1.append(paramUri);
    throw new FileNotFoundException(localStringBuilder1.toString());
  }
  
  private Drawable getDrawableFromResourceValue(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      if ("0".equals(paramString)) {
        return null;
      }
    }
    try
    {
      int i = Integer.parseInt(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("android.resource://");
      ((StringBuilder)localObject).append(this.mProviderContext.getPackageName());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      Drawable localDrawable = checkIconCache((String)localObject);
      if (localDrawable != null) {
        return localDrawable;
      }
      localDrawable = ContextCompat.getDrawable(this.mProviderContext, i);
      storeInIconCache((String)localObject, localDrawable);
      return localDrawable;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Object localObject;
      break label144;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label110:
      break label110;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Icon resource not found: ");
    ((StringBuilder)localObject).append(paramString);
    Log.w("SuggestionsAdapter", ((StringBuilder)localObject).toString());
    return null;
    label144:
    localObject = checkIconCache(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = getDrawable(Uri.parse(paramString));
    storeInIconCache(paramString, (Drawable)localObject);
    return localObject;
    return null;
  }
  
  private Drawable getIcon1(Cursor paramCursor)
  {
    int i = this.mIconName1Col;
    if (i == -1) {
      return null;
    }
    Drawable localDrawable = getDrawableFromResourceValue(paramCursor.getString(i));
    if (localDrawable != null) {
      return localDrawable;
    }
    return getDefaultIcon1(paramCursor);
  }
  
  private Drawable getIcon2(Cursor paramCursor)
  {
    int i = this.mIconName2Col;
    if (i == -1) {
      return null;
    }
    return getDrawableFromResourceValue(paramCursor.getString(i));
  }
  
  private static String getStringOrNull(Cursor paramCursor, int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", paramCursor);
    }
    return null;
  }
  
  private void setViewDrawable(ImageView paramImageView, Drawable paramDrawable, int paramInt)
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
  
  private void setViewText(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
  }
  
  private void storeInIconCache(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.mOutsideDrawablesCache.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private void updateSpinnerState(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor = paramCursor.getExtras();
    } else {
      paramCursor = null;
    }
    if ((paramCursor != null) && (paramCursor.getBoolean("in_progress"))) {}
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    paramContext = (ChildViewCache)paramView.getTag();
    int i = this.mFlagsCol;
    if (i != -1) {
      i = paramCursor.getInt(i);
    } else {
      i = 0;
    }
    if (paramContext.mText1 != null)
    {
      paramView = getStringOrNull(paramCursor, this.mText1Col);
      setViewText(paramContext.mText1, paramView);
    }
    if (paramContext.mText2 != null)
    {
      paramView = getStringOrNull(paramCursor, this.mText2UrlCol);
      if (paramView != null) {
        paramView = formatUrl(paramView);
      } else {
        paramView = getStringOrNull(paramCursor, this.mText2Col);
      }
      if (TextUtils.isEmpty(paramView))
      {
        if (paramContext.mText1 != null)
        {
          paramContext.mText1.setSingleLine(false);
          paramContext.mText1.setMaxLines(2);
        }
      }
      else if (paramContext.mText1 != null)
      {
        paramContext.mText1.setSingleLine(true);
        paramContext.mText1.setMaxLines(1);
      }
      setViewText(paramContext.mText2, paramView);
    }
    if (paramContext.mIcon1 != null) {
      setViewDrawable(paramContext.mIcon1, getIcon1(paramCursor), 4);
    }
    if (paramContext.mIcon2 != null) {
      setViewDrawable(paramContext.mIcon2, getIcon2(paramCursor), 8);
    }
    int j = this.mQueryRefinement;
    if ((j != 2) && ((j != 1) || ((i & 0x1) == 0)))
    {
      paramContext.mIconRefine.setVisibility(8);
      return;
    }
    paramContext.mIconRefine.setVisibility(0);
    paramContext.mIconRefine.setTag(paramContext.mText1.getText());
    paramContext.mIconRefine.setOnClickListener(this);
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (this.mClosed)
    {
      Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
    }
    try
    {
      super.changeCursor(paramCursor);
      if (paramCursor != null)
      {
        this.mText1Col = paramCursor.getColumnIndex("suggest_text_1");
        this.mText2Col = paramCursor.getColumnIndex("suggest_text_2");
        this.mText2UrlCol = paramCursor.getColumnIndex("suggest_text_2_url");
        this.mIconName1Col = paramCursor.getColumnIndex("suggest_icon_1");
        this.mIconName2Col = paramCursor.getColumnIndex("suggest_icon_2");
        this.mFlagsCol = paramCursor.getColumnIndex("suggest_flags");
        return;
      }
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "error changing cursor and caching columns", paramCursor);
    }
  }
  
  public void close()
  {
    changeCursor(null);
    this.mClosed = true;
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    String str = getColumnString(paramCursor, "suggest_intent_query");
    if (str != null) {
      return str;
    }
    if (this.mSearchable.shouldRewriteQueryFromData())
    {
      str = getColumnString(paramCursor, "suggest_intent_data");
      if (str != null) {
        return str;
      }
    }
    if (this.mSearchable.shouldRewriteQueryFromText())
    {
      paramCursor = getColumnString(paramCursor, "suggest_text_1");
      if (paramCursor != null) {
        return paramCursor;
      }
    }
    return null;
  }
  
  Drawable getDrawableFromResourceUri(Uri paramUri)
  {
    Object localObject = paramUri.getAuthority();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localResources = this.mContext.getPackageManager().getResourcesForApplication((String)localObject);
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
      break label248;
    }
    try
    {
      i = Integer.parseInt((String)localList.get(0));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label67;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Single path segment is not a resource ID: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
    if (i == 2)
    {
      i = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), (String)localObject);
      if (i != 0) {
        return localResources.getDrawable(i);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No resource found for: ");
      ((StringBuilder)localObject).append(paramUri);
      throw new FileNotFoundException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("More than two path segments: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No path: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
    label248:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No package found for authority: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No authority: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = newDropDownView(this.mContext, this.mCursor, paramViewGroup);
      if (paramViewGroup != null) {
        ((ChildViewCache)paramViewGroup.getTag()).mText1.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public int getQueryRefinement()
  {
    return this.mQueryRefinement;
  }
  
  Cursor getSearchManagerSuggestions(SearchableInfo paramSearchableInfo, String paramString, int paramInt)
  {
    if (paramSearchableInfo == null) {
      return null;
    }
    Object localObject = paramSearchableInfo.getSuggestAuthority();
    if (localObject == null) {
      return null;
    }
    localObject = new Uri.Builder().scheme("content").authority((String)localObject).query("").fragment("");
    String str = paramSearchableInfo.getSuggestPath();
    if (str != null) {
      ((Uri.Builder)localObject).appendEncodedPath(str);
    }
    ((Uri.Builder)localObject).appendPath("search_suggest_query");
    str = paramSearchableInfo.getSuggestSelection();
    if (str != null)
    {
      paramSearchableInfo = new String[] { paramString };
    }
    else
    {
      ((Uri.Builder)localObject).appendPath(paramString);
      paramSearchableInfo = null;
    }
    if (paramInt > 0) {
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    paramString = ((Uri.Builder)localObject).build();
    return this.mContext.getContentResolver().query(paramString, null, str, paramSearchableInfo, null);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = newView(this.mContext, this.mCursor, paramViewGroup);
      if (paramViewGroup != null) {
        ((ChildViewCache)paramViewGroup.getTag()).mText1.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = super.newView(paramContext, paramCursor, paramViewGroup);
    paramContext.setTag(new ChildViewCache(paramContext));
    ((ImageView)paramContext.findViewById(R.id.edit_query)).setImageResource(this.mCommitIconResId);
    return paramContext;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    updateSpinnerState(getCursor());
  }
  
  public void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    updateSpinnerState(getCursor());
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      this.mSearchView.onQueryRefine((CharSequence)paramView);
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    } else {
      paramCharSequence = paramCharSequence.toString();
    }
    if (this.mSearchView.getVisibility() == 0)
    {
      if (this.mSearchView.getWindowVisibility() != 0) {
        return null;
      }
      try
      {
        paramCharSequence = getSearchManagerSuggestions(this.mSearchable, paramCharSequence, 50);
        if (paramCharSequence != null)
        {
          paramCharSequence.getCount();
          return paramCharSequence;
        }
      }
      catch (RuntimeException paramCharSequence)
      {
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", paramCharSequence);
      }
      return null;
    }
    return null;
  }
  
  public void setQueryRefinement(int paramInt)
  {
    this.mQueryRefinement = paramInt;
  }
  
  private static final class ChildViewCache
  {
    public final ImageView mIcon1;
    public final ImageView mIcon2;
    public final ImageView mIconRefine;
    public final TextView mText1;
    public final TextView mText2;
    
    public ChildViewCache(View paramView)
    {
      this.mText1 = ((TextView)paramView.findViewById(16908308));
      this.mText2 = ((TextView)paramView.findViewById(16908309));
      this.mIcon1 = ((ImageView)paramView.findViewById(16908295));
      this.mIcon2 = ((ImageView)paramView.findViewById(16908296));
      this.mIconRefine = ((ImageView)paramView.findViewById(R.id.edit_query));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.SuggestionsAdapter
 * JD-Core Version:    0.7.0.1
 */