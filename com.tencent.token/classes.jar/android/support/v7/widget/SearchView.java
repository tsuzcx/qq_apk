package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.token.ew;
import com.tencent.token.fp;
import com.tencent.token.go.a;
import com.tencent.token.go.d;
import com.tencent.token.go.f;
import com.tencent.token.go.g;
import com.tencent.token.go.h;
import com.tencent.token.go.j;
import com.tencent.token.gx;
import com.tencent.token.iz;
import com.tencent.token.je;
import com.tencent.token.jg;
import com.tencent.token.jk;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements gx
{
  static final a p = new a();
  private final int A;
  private final int B;
  private final CharSequence C;
  private c D;
  private b E;
  private View.OnClickListener F;
  private boolean G;
  private boolean H;
  private CharSequence I;
  private boolean J;
  private boolean K;
  private int L;
  private boolean M;
  private CharSequence N;
  private CharSequence O;
  private boolean P;
  private int Q;
  private final Runnable R = new Runnable()
  {
    public final void run()
    {
      SearchView.this.d();
    }
  };
  private Runnable S = new Runnable()
  {
    public final void run()
    {
      if ((SearchView.this.m != null) && ((SearchView.this.m instanceof iz))) {
        SearchView.this.m.a(null);
      }
    }
  };
  private final WeakHashMap<String, Drawable.ConstantState> T = new WeakHashMap();
  private final View.OnClickListener U = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (paramAnonymousView == SearchView.this.c)
      {
        SearchView.this.g();
        return;
      }
      if (paramAnonymousView == SearchView.this.e)
      {
        SearchView.this.f();
        return;
      }
      if (paramAnonymousView == SearchView.this.d)
      {
        SearchView.this.e();
        return;
      }
      SearchView localSearchView;
      SearchableInfo localSearchableInfo;
      if (paramAnonymousView == SearchView.this.f)
      {
        localSearchView = SearchView.this;
        if (localSearchView.n != null) {
          localSearchableInfo = localSearchView.n;
        }
      }
      for (;;)
      {
        try
        {
          boolean bool = localSearchableInfo.getVoiceSearchLaunchWebSearch();
          Object localObject3 = null;
          paramAnonymousView = null;
          if (bool)
          {
            localObject1 = new Intent(localSearchView.h);
            localObject2 = localSearchableInfo.getSearchActivity();
            if (localObject2 != null) {
              paramAnonymousView = ((ComponentName)localObject2).flattenToShortString();
            }
            ((Intent)localObject1).putExtra("calling_package", paramAnonymousView);
            localSearchView.getContext().startActivity((Intent)localObject1);
            return;
          }
          if (localSearchableInfo.getVoiceSearchLaunchRecognizer())
          {
            paramAnonymousView = localSearchView.i;
            ComponentName localComponentName = localSearchableInfo.getSearchActivity();
            localObject1 = new Intent("android.intent.action.SEARCH");
            ((Intent)localObject1).setComponent(localComponentName);
            PendingIntent localPendingIntent = PendingIntent.getActivity(localSearchView.getContext(), 0, (Intent)localObject1, 1073741824);
            Bundle localBundle = new Bundle();
            if (localSearchView.o != null) {
              localBundle.putParcelable("app_data", localSearchView.o);
            }
            Intent localIntent = new Intent(paramAnonymousView);
            paramAnonymousView = "free_form";
            int i = 1;
            localObject2 = localSearchView.getResources();
            if (localSearchableInfo.getVoiceLanguageModeId() != 0) {
              paramAnonymousView = ((Resources)localObject2).getString(localSearchableInfo.getVoiceLanguageModeId());
            }
            if (localSearchableInfo.getVoicePromptTextId() == 0) {
              break label461;
            }
            localObject1 = ((Resources)localObject2).getString(localSearchableInfo.getVoicePromptTextId());
            if (localSearchableInfo.getVoiceLanguageId() == 0) {
              break label467;
            }
            localObject2 = ((Resources)localObject2).getString(localSearchableInfo.getVoiceLanguageId());
            if (localSearchableInfo.getVoiceMaxResults() != 0) {
              i = localSearchableInfo.getVoiceMaxResults();
            }
            localIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", paramAnonymousView);
            localIntent.putExtra("android.speech.extra.PROMPT", (String)localObject1);
            localIntent.putExtra("android.speech.extra.LANGUAGE", (String)localObject2);
            localIntent.putExtra("android.speech.extra.MAX_RESULTS", i);
            if (localComponentName == null) {
              paramAnonymousView = localObject3;
            } else {
              paramAnonymousView = localComponentName.flattenToShortString();
            }
            localIntent.putExtra("calling_package", paramAnonymousView);
            localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
            localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
            localSearchView.getContext().startActivity(localIntent);
          }
          return;
        }
        catch (ActivityNotFoundException paramAnonymousView)
        {
          return;
        }
        return;
        if (paramAnonymousView == SearchView.this.a) {
          SearchView.this.i();
        }
        return;
        label461:
        Object localObject1 = null;
        continue;
        label467:
        Object localObject2 = null;
      }
    }
  };
  private final TextView.OnEditorActionListener V = new TextView.OnEditorActionListener()
  {
    public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      SearchView.this.e();
      return true;
    }
  };
  private final AdapterView.OnItemClickListener W = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      SearchView.this.b(paramAnonymousInt);
    }
  };
  final SearchAutoComplete a;
  private final AdapterView.OnItemSelectedListener aa = new AdapterView.OnItemSelectedListener()
  {
    public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = SearchView.this;
      if ((paramAnonymousAdapterView.k == null) || (!paramAnonymousAdapterView.k.a()))
      {
        paramAnonymousView = paramAnonymousAdapterView.a.getText();
        Object localObject = paramAnonymousAdapterView.m.a();
        if (localObject != null)
        {
          if (((Cursor)localObject).moveToPosition(paramAnonymousInt))
          {
            localObject = paramAnonymousAdapterView.m.b((Cursor)localObject);
            if (localObject != null)
            {
              paramAnonymousAdapterView.setQuery((CharSequence)localObject);
              return;
            }
            paramAnonymousAdapterView.setQuery(paramAnonymousView);
            return;
          }
          paramAnonymousAdapterView.setQuery(paramAnonymousView);
        }
      }
    }
    
    public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
  };
  private TextWatcher ab = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable) {}
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      SearchView.this.a(paramAnonymousCharSequence);
    }
  };
  final View b;
  final ImageView c;
  final ImageView d;
  final ImageView e;
  final ImageView f;
  final View g;
  final Intent h;
  final Intent i;
  View.OnFocusChangeListener j;
  d k;
  boolean l;
  fp m;
  SearchableInfo n;
  Bundle o;
  View.OnKeyListener q = new View.OnKeyListener()
  {
    public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (SearchView.this.n == null) {
        return false;
      }
      if ((SearchView.this.a.isPopupShowing()) && (SearchView.this.a.getListSelection() != -1)) {
        return SearchView.this.a(paramAnonymousInt, paramAnonymousKeyEvent);
      }
      if ((!SearchView.SearchAutoComplete.a(SearchView.this.a)) && (paramAnonymousKeyEvent.hasNoModifiers()) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousInt == 66))
      {
        paramAnonymousView.cancelLongPress();
        paramAnonymousView = SearchView.this;
        paramAnonymousView.a(paramAnonymousView.a.getText().toString());
        return true;
      }
      return false;
    }
  };
  private final View r;
  private final View s;
  private e t;
  private Rect u = new Rect();
  private Rect v = new Rect();
  private int[] w = new int[2];
  private int[] x = new int[2];
  private final ImageView y;
  private final Drawable z;
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, go.a.searchViewStyle);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = je.a(paramContext, paramAttributeSet, go.j.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.g(go.j.SearchView_layout, go.g.abc_search_view), this, true);
    this.a = ((SearchAutoComplete)findViewById(go.f.search_src_text));
    this.a.setSearchView(this);
    this.r = findViewById(go.f.search_edit_frame);
    this.b = findViewById(go.f.search_plate);
    this.s = findViewById(go.f.submit_area);
    this.c = ((ImageView)findViewById(go.f.search_button));
    this.d = ((ImageView)findViewById(go.f.search_go_btn));
    this.e = ((ImageView)findViewById(go.f.search_close_btn));
    this.f = ((ImageView)findViewById(go.f.search_voice_btn));
    this.y = ((ImageView)findViewById(go.f.search_mag_icon));
    ew.a(this.b, paramAttributeSet.a(go.j.SearchView_queryBackground));
    ew.a(this.s, paramAttributeSet.a(go.j.SearchView_submitBackground));
    this.c.setImageDrawable(paramAttributeSet.a(go.j.SearchView_searchIcon));
    this.d.setImageDrawable(paramAttributeSet.a(go.j.SearchView_goIcon));
    this.e.setImageDrawable(paramAttributeSet.a(go.j.SearchView_closeIcon));
    this.f.setImageDrawable(paramAttributeSet.a(go.j.SearchView_voiceIcon));
    this.y.setImageDrawable(paramAttributeSet.a(go.j.SearchView_searchIcon));
    this.z = paramAttributeSet.a(go.j.SearchView_searchHintIcon);
    jg.a(this.c, getResources().getString(go.h.abc_searchview_description_search));
    this.A = paramAttributeSet.g(go.j.SearchView_suggestionRowLayout, go.g.abc_search_dropdown_item_icons_2line);
    this.B = paramAttributeSet.g(go.j.SearchView_commitIcon, 0);
    this.c.setOnClickListener(this.U);
    this.e.setOnClickListener(this.U);
    this.d.setOnClickListener(this.U);
    this.f.setOnClickListener(this.U);
    this.a.setOnClickListener(this.U);
    this.a.addTextChangedListener(this.ab);
    this.a.setOnEditorActionListener(this.V);
    this.a.setOnItemClickListener(this.W);
    this.a.setOnItemSelectedListener(this.aa);
    this.a.setOnKeyListener(this.q);
    this.a.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (SearchView.this.j != null) {
          SearchView.this.j.onFocusChange(SearchView.this, paramAnonymousBoolean);
        }
      }
    });
    setIconifiedByDefault(paramAttributeSet.a(go.j.SearchView_iconifiedByDefault, true));
    paramInt = paramAttributeSet.e(go.j.SearchView_android_maxWidth, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.C = paramAttributeSet.c(go.j.SearchView_defaultQueryHint);
    this.I = paramAttributeSet.c(go.j.SearchView_queryHint);
    paramInt = paramAttributeSet.a(go.j.SearchView_android_imeOptions, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.a(go.j.SearchView_android_inputType, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.a(go.j.SearchView_android_focusable, true));
    paramAttributeSet.a.recycle();
    this.h = new Intent("android.speech.action.WEB_SEARCH");
    this.h.addFlags(268435456);
    this.h.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.i = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.i.addFlags(268435456);
    this.g = findViewById(this.a.getDropDownAnchor());
    paramContext = this.g;
    if (paramContext != null) {
      paramContext.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          paramAnonymousView = SearchView.this;
          if (paramAnonymousView.g.getWidth() > 1)
          {
            Resources localResources = paramAnonymousView.getContext().getResources();
            paramAnonymousInt3 = paramAnonymousView.b.getPaddingLeft();
            Rect localRect = new Rect();
            boolean bool = jk.a(paramAnonymousView);
            if (paramAnonymousView.l) {
              paramAnonymousInt1 = localResources.getDimensionPixelSize(go.d.abc_dropdownitem_icon_width) + localResources.getDimensionPixelSize(go.d.abc_dropdownitem_text_padding_left);
            } else {
              paramAnonymousInt1 = 0;
            }
            paramAnonymousView.a.getDropDownBackground().getPadding(localRect);
            if (bool) {
              paramAnonymousInt2 = -localRect.left;
            } else {
              paramAnonymousInt2 = paramAnonymousInt3 - (localRect.left + paramAnonymousInt1);
            }
            paramAnonymousView.a.setDropDownHorizontalOffset(paramAnonymousInt2);
            paramAnonymousInt2 = paramAnonymousView.g.getWidth();
            paramAnonymousInt4 = localRect.left;
            paramAnonymousInt5 = localRect.right;
            paramAnonymousView.a.setDropDownWidth(paramAnonymousInt2 + paramAnonymousInt4 + paramAnonymousInt5 + paramAnonymousInt1 - paramAnonymousInt3);
          }
        }
      });
    }
    a(this.l);
    n();
  }
  
  private Intent a(Cursor paramCursor)
  {
    try
    {
      localObject3 = iz.a(paramCursor, "suggest_intent_action");
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label204;
      }
      localObject1 = this.n.getSuggestIntentAction();
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject4;
        String str;
        label167:
        continue;
        label204:
        Object localObject3 = localRuntimeException;
        if (localRuntimeException == null)
        {
          localObject3 = "android.intent.action.SEARCH";
          continue;
          label219:
          if (localObject4 == null) {
            Object localObject2 = null;
          }
        }
      }
    }
    localObject4 = iz.a(paramCursor, "suggest_intent_data");
    localObject1 = localObject4;
    if (localObject4 == null) {
      localObject1 = this.n.getSuggestIntentData();
    }
    localObject4 = localObject1;
    if (localObject1 != null)
    {
      str = iz.a(paramCursor, "suggest_intent_data_id");
      localObject4 = localObject1;
      if (str != null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append("/");
        ((StringBuilder)localObject4).append(Uri.encode(str));
        localObject4 = ((StringBuilder)localObject4).toString();
        break label219;
        localObject1 = Uri.parse((String)localObject4);
        localObject4 = iz.a(paramCursor, "suggest_intent_query");
        localObject1 = a((String)localObject3, (Uri)localObject1, iz.a(paramCursor, "suggest_intent_extra_data"), (String)localObject4);
        return localObject1;
        try
        {
          i1 = paramCursor.getPosition();
        }
        catch (RuntimeException paramCursor)
        {
          int i1;
          break label167;
        }
        i1 = -1;
        paramCursor = new StringBuilder("Search suggestions cursor at row ");
        paramCursor.append(i1);
        paramCursor.append(" returned exception.");
        return null;
      }
    }
  }
  
  private Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", this.O);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    paramUri = this.o;
    if (paramUri != null) {
      paramString1.putExtra("app_data", paramUri);
    }
    paramString1.setComponent(this.n.getSearchActivity());
    return paramString1;
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      getContext().startActivity(paramIntent);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      label14:
      break label14;
    }
    new StringBuilder("Failed launch activity: ").append(paramIntent);
  }
  
  private void a(boolean paramBoolean)
  {
    this.G = paramBoolean;
    int i2 = 8;
    boolean bool1 = false;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    boolean bool2 = TextUtils.isEmpty(this.a.getText()) ^ true;
    this.c.setVisibility(i1);
    b(bool2);
    View localView = this.r;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    localView.setVisibility(i1);
    int i1 = i2;
    if (this.y.getDrawable() != null) {
      if (this.l) {
        i1 = i2;
      } else {
        i1 = 0;
      }
    }
    this.y.setVisibility(i1);
    l();
    paramBoolean = bool1;
    if (!bool2) {
      paramBoolean = true;
    }
    c(paramBoolean);
    k();
  }
  
  static boolean a(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  private CharSequence b(CharSequence paramCharSequence)
  {
    if (this.l)
    {
      if (this.z == null) {
        return paramCharSequence;
      }
      double d1 = this.a.getTextSize();
      Double.isNaN(d1);
      int i1 = (int)(d1 * 1.25D);
      this.z.setBounds(0, 0, i1, i1);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
      localSpannableStringBuilder.setSpan(new ImageSpan(this.z), 1, 2, 33);
      localSpannableStringBuilder.append(paramCharSequence);
      return localSpannableStringBuilder;
    }
    return paramCharSequence;
  }
  
  private void b(boolean paramBoolean)
  {
    int i1;
    if ((this.H) && (j()) && (hasFocus()) && ((paramBoolean) || (!this.M))) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    this.d.setVisibility(i1);
  }
  
  private void c(boolean paramBoolean)
  {
    int i1;
    if ((this.M) && (!this.G) && (paramBoolean))
    {
      i1 = 0;
      this.d.setVisibility(8);
    }
    else
    {
      i1 = 8;
    }
    this.f.setVisibility(i1);
  }
  
  private boolean c(int paramInt)
  {
    Cursor localCursor = this.m.a();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt)))
    {
      a(a(localCursor));
      return true;
    }
    return false;
  }
  
  private int getPreferredHeight()
  {
    return getContext().getResources().getDimensionPixelSize(go.d.abc_search_view_preferred_height);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(go.d.abc_search_view_preferred_width);
  }
  
  private boolean j()
  {
    return ((this.H) || (this.M)) && (!this.G);
  }
  
  private void k()
  {
    int i1;
    if ((j()) && ((this.d.getVisibility() == 0) || (this.f.getVisibility() == 0))) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    this.s.setVisibility(i1);
  }
  
  private void l()
  {
    boolean bool = TextUtils.isEmpty(this.a.getText());
    int i3 = 1;
    int i4 = bool ^ true;
    int i2 = 0;
    int i1 = i3;
    if (i4 == 0) {
      if ((this.l) && (!this.P)) {
        i1 = i3;
      } else {
        i1 = 0;
      }
    }
    Object localObject = this.e;
    if (i1 != 0) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((ImageView)localObject).setVisibility(i1);
    Drawable localDrawable = this.e.getDrawable();
    if (localDrawable != null)
    {
      if (i4 != 0) {
        localObject = ENABLED_STATE_SET;
      } else {
        localObject = EMPTY_STATE_SET;
      }
      localDrawable.setState((int[])localObject);
    }
  }
  
  private void m()
  {
    post(this.R);
  }
  
  private void n()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = this.a;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(b((CharSequence)localObject));
  }
  
  public final void a()
  {
    if (this.P) {
      return;
    }
    this.P = true;
    this.Q = this.a.getImeOptions();
    this.a.setImeOptions(this.Q | 0x2000000);
    this.a.setText("");
    setIconified(false);
  }
  
  final void a(CharSequence paramCharSequence)
  {
    Editable localEditable = this.a.getText();
    this.O = localEditable;
    boolean bool2 = TextUtils.isEmpty(localEditable);
    boolean bool1 = true;
    bool2 ^= true;
    b(bool2);
    if (bool2) {
      bool1 = false;
    }
    c(bool1);
    l();
    k();
    if ((this.D != null) && (!TextUtils.equals(paramCharSequence, this.N))) {
      paramCharSequence.toString();
    }
    this.N = paramCharSequence.toString();
  }
  
  final void a(String paramString)
  {
    paramString = a("android.intent.action.SEARCH", null, null, paramString);
    getContext().startActivity(paramString);
  }
  
  final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.n == null) {
      return false;
    }
    if (this.m == null) {
      return false;
    }
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.hasNoModifiers())) {
      if ((paramInt != 66) && (paramInt != 84) && (paramInt != 61))
      {
        if ((paramInt != 21) && (paramInt != 22))
        {
          if ((paramInt == 19) && (this.a.getListSelection() == 0)) {
            return false;
          }
        }
        else
        {
          if (paramInt == 21) {
            paramInt = 0;
          } else {
            paramInt = this.a.length();
          }
          this.a.setSelection(paramInt);
          this.a.setListSelection(0);
          this.a.clearListSelection();
          p.c(this.a);
          return true;
        }
      }
      else {
        return b(this.a.getListSelection());
      }
    }
    return false;
  }
  
  public final void b()
  {
    this.a.setText("");
    SearchAutoComplete localSearchAutoComplete = this.a;
    localSearchAutoComplete.setSelection(localSearchAutoComplete.length());
    this.O = "";
    clearFocus();
    a(true);
    this.a.setImeOptions(this.Q);
    this.P = false;
  }
  
  final boolean b(int paramInt)
  {
    d locald = this.k;
    if ((locald != null) && (locald.b())) {
      return false;
    }
    c(paramInt);
    SearchAutoComplete.a(this.a, false);
    this.a.dismissDropDown();
    return true;
  }
  
  public void clearFocus()
  {
    this.K = true;
    super.clearFocus();
    this.a.clearFocus();
    SearchAutoComplete.a(this.a, false);
    this.K = false;
  }
  
  final void d()
  {
    int[] arrayOfInt;
    if (this.a.hasFocus()) {
      arrayOfInt = FOCUSED_STATE_SET;
    } else {
      arrayOfInt = EMPTY_STATE_SET;
    }
    Drawable localDrawable = this.b.getBackground();
    if (localDrawable != null) {
      localDrawable.setState(arrayOfInt);
    }
    localDrawable = this.s.getBackground();
    if (localDrawable != null) {
      localDrawable.setState(arrayOfInt);
    }
    invalidate();
  }
  
  final void e()
  {
    Editable localEditable = this.a.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0))
    {
      c localc = this.D;
      if (localc != null)
      {
        localEditable.toString();
        if (localc.a()) {}
      }
      else
      {
        if (this.n != null) {
          a(localEditable.toString());
        }
        SearchAutoComplete.a(this.a, false);
        this.a.dismissDropDown();
      }
    }
  }
  
  final void f()
  {
    if (TextUtils.isEmpty(this.a.getText()))
    {
      if (this.l)
      {
        b localb = this.E;
        if ((localb == null) || (!localb.a()))
        {
          clearFocus();
          a(true);
        }
      }
    }
    else
    {
      this.a.setText("");
      this.a.requestFocus();
      SearchAutoComplete.a(this.a, true);
    }
  }
  
  final void g()
  {
    a(false);
    this.a.requestFocus();
    SearchAutoComplete.a(this.a, true);
    View.OnClickListener localOnClickListener = this.F;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this);
    }
  }
  
  public int getImeOptions()
  {
    return this.a.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.a.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.L;
  }
  
  public CharSequence getQuery()
  {
    return this.a.getText();
  }
  
  public CharSequence getQueryHint()
  {
    Object localObject = this.I;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.n;
    if ((localObject != null) && (((SearchableInfo)localObject).getHintId() != 0)) {
      return getContext().getText(this.n.getHintId());
    }
    return this.C;
  }
  
  public int getSuggestionCommitIconResId()
  {
    return this.B;
  }
  
  public int getSuggestionRowLayout()
  {
    return this.A;
  }
  
  public fp getSuggestionsAdapter()
  {
    return this.m;
  }
  
  final void h()
  {
    a(this.G);
    m();
    if (this.a.hasFocus()) {
      i();
    }
  }
  
  final void i()
  {
    p.a(this.a);
    p.b(this.a);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.R);
    post(this.S);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      Object localObject = this.a;
      Rect localRect = this.u;
      ((View)localObject).getLocationInWindow(this.w);
      getLocationInWindow(this.x);
      int[] arrayOfInt1 = this.w;
      paramInt1 = arrayOfInt1[1];
      int[] arrayOfInt2 = this.x;
      paramInt1 -= arrayOfInt2[1];
      paramInt3 = arrayOfInt1[0] - arrayOfInt2[0];
      localRect.set(paramInt3, paramInt1, ((View)localObject).getWidth() + paramInt3, ((View)localObject).getHeight() + paramInt1);
      this.v.set(this.u.left, 0, this.u.right, paramInt4 - paramInt2);
      localObject = this.t;
      if (localObject == null)
      {
        this.t = new e(this.v, this.u, this.a);
        setTouchDelegate(this.t);
        return;
      }
      ((e)localObject).a(this.v, this.u);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.G)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    if (i2 != -2147483648)
    {
      if (i2 != 0)
      {
        if (i2 != 1073741824)
        {
          paramInt1 = i1;
        }
        else
        {
          i2 = this.L;
          paramInt1 = i1;
          if (i2 > 0) {
            paramInt1 = Math.min(i2, i1);
          }
        }
      }
      else
      {
        paramInt1 = this.L;
        if (paramInt1 <= 0) {
          paramInt1 = getPreferredWidth();
        }
      }
    }
    else
    {
      paramInt1 = this.L;
      if (paramInt1 > 0) {
        paramInt1 = Math.min(paramInt1, i1);
      } else {
        paramInt1 = Math.min(getPreferredWidth(), i1);
      }
    }
    i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i1 != -2147483648)
    {
      if (i1 == 0) {
        paramInt2 = getPreferredHeight();
      }
    }
    else {
      paramInt2 = Math.min(getPreferredHeight(), paramInt2);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.c);
    a(paramParcelable.a);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = this.G;
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    m();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.K) {
      return false;
    }
    if (!isFocusable()) {
      return false;
    }
    if (!this.G)
    {
      boolean bool = this.a.requestFocus(paramInt, paramRect);
      if (bool) {
        a(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.o = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      f();
      return;
    }
    g();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.l == paramBoolean) {
      return;
    }
    this.l = paramBoolean;
    a(paramBoolean);
    n();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.a.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.a.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.L = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(b paramb)
  {
    this.E = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.j = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(c paramc)
  {
    this.D = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.F = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(d paramd)
  {
    this.k = paramd;
  }
  
  public void setQuery(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = this.a;
    int i1;
    if (TextUtils.isEmpty(paramCharSequence)) {
      i1 = 0;
    } else {
      i1 = paramCharSequence.length();
    }
    localSearchAutoComplete.setSelection(i1);
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.I = paramCharSequence;
    n();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.J = paramBoolean;
    Object localObject = this.m;
    if ((localObject instanceof iz))
    {
      localObject = (iz)localObject;
      int i1;
      if (paramBoolean) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      ((iz)localObject).j = i1;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    this.n = paramSearchableInfo;
    Object localObject = this.n;
    paramSearchableInfo = null;
    if (localObject != null)
    {
      this.a.setThreshold(((SearchableInfo)localObject).getSuggestThreshold());
      this.a.setImeOptions(this.n.getImeOptions());
      int i2 = this.n.getInputType();
      int i1 = i2;
      if ((i2 & 0xF) == 1)
      {
        i2 &= 0xFFFEFFFF;
        i1 = i2;
        if (this.n.getSuggestAuthority() != null) {
          i1 = i2 | 0x10000 | 0x80000;
        }
      }
      this.a.setInputType(i1);
      localObject = this.m;
      if (localObject != null) {
        ((fp)localObject).a(null);
      }
      if (this.n.getSuggestAuthority() != null)
      {
        this.m = new iz(getContext(), this, this.n, this.T);
        this.a.setAdapter(this.m);
        localObject = (iz)this.m;
        if (this.J) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        ((iz)localObject).j = i1;
      }
      n();
    }
    localObject = this.n;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((SearchableInfo)localObject).getVoiceSearchEnabled())
      {
        if (this.n.getVoiceSearchLaunchWebSearch()) {
          paramSearchableInfo = this.h;
        } else if (this.n.getVoiceSearchLaunchRecognizer()) {
          paramSearchableInfo = this.i;
        }
        bool1 = bool2;
        if (paramSearchableInfo != null)
        {
          bool1 = bool2;
          if (getContext().getPackageManager().resolveActivity(paramSearchableInfo, 65536) != null) {
            bool1 = true;
          }
        }
      }
    }
    this.M = bool1;
    if (this.M) {
      this.a.setPrivateImeOptions("nm");
    }
    a(this.G);
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    this.H = paramBoolean;
    a(this.G);
  }
  
  public void setSuggestionsAdapter(fp paramfp)
  {
    this.m = paramfp;
    this.a.setAdapter(this.m);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    boolean a;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.a = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("SearchView.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" isIconified=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.a));
    }
  }
  
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    final Runnable a = new Runnable()
    {
      public final void run()
      {
        SearchView.SearchAutoComplete.b(SearchView.SearchAutoComplete.this);
      }
    };
    private int b = getThreshold();
    private SearchView c;
    private boolean d;
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, go.a.autoCompleteTextViewStyle);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    private int getSearchViewTextMinWidthDp()
    {
      Configuration localConfiguration = getResources().getConfiguration();
      int i = localConfiguration.screenWidthDp;
      int j = localConfiguration.screenHeightDp;
      if ((i >= 960) && (j >= 720) && (localConfiguration.orientation == 2)) {
        return 256;
      }
      if ((i < 600) && ((i < 640) || (j < 480))) {
        return 160;
      }
      return 192;
    }
    
    private void setImeVisibility(boolean paramBoolean)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (!paramBoolean)
      {
        this.d = false;
        removeCallbacks(this.a);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        this.d = false;
        removeCallbacks(this.a);
        localInputMethodManager.showSoftInput(this, 0);
        return;
      }
      this.d = true;
    }
    
    public boolean enoughToFilter()
    {
      return (this.b <= 0) || (super.enoughToFilter());
    }
    
    public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      if (this.d)
      {
        removeCallbacks(this.a);
        post(this.a);
      }
      return paramEditorInfo;
    }
    
    protected void onFinishInflate()
    {
      super.onFinishInflate();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
    }
    
    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.c.h();
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            this.c.clearFocus();
            setImeVisibility(false);
            return true;
          }
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      if ((paramBoolean) && (this.c.hasFocus()) && (getVisibility() == 0))
      {
        this.d = true;
        if (SearchView.a(getContext())) {
          SearchView.p.c(this);
        }
      }
    }
    
    public void performCompletion() {}
    
    protected void replaceText(CharSequence paramCharSequence) {}
    
    void setSearchView(SearchView paramSearchView)
    {
      this.c = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      this.b = paramInt;
    }
  }
  
  static final class a
  {
    private Method a;
    private Method b;
    private Method c;
    
    a()
    {
      try
      {
        this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.a.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        try
        {
          for (;;)
          {
            this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.b.setAccessible(true);
            try
            {
              label50:
              this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
              this.c.setAccessible(true);
              return;
            }
            catch (NoSuchMethodException localNoSuchMethodException3) {}
            localNoSuchMethodException1 = localNoSuchMethodException1;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          break label50;
        }
      }
    }
    
    final void a(AutoCompleteTextView paramAutoCompleteTextView)
    {
      Method localMethod = this.a;
      if (localMethod != null) {}
      try
      {
        localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
      return;
    }
    
    final void b(AutoCompleteTextView paramAutoCompleteTextView)
    {
      Method localMethod = this.b;
      if (localMethod != null) {}
      try
      {
        localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
      return;
    }
    
    final void c(AutoCompleteTextView paramAutoCompleteTextView)
    {
      Method localMethod = this.c;
      if (localMethod != null) {}
      try
      {
        localMethod.invoke(paramAutoCompleteTextView, new Object[] { Boolean.TRUE });
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
      return;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a();
  }
  
  public static abstract interface c
  {
    public abstract boolean a();
  }
  
  public static abstract interface d
  {
    public abstract boolean a();
    
    public abstract boolean b();
  }
  
  static final class e
    extends TouchDelegate
  {
    private final View a;
    private final Rect b;
    private final Rect c;
    private final Rect d;
    private final int e;
    private boolean f;
    
    public e(Rect paramRect1, Rect paramRect2, View paramView)
    {
      super(paramView);
      this.e = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      this.b = new Rect();
      this.d = new Rect();
      this.c = new Rect();
      a(paramRect1, paramRect2);
      this.a = paramView;
    }
    
    public final void a(Rect paramRect1, Rect paramRect2)
    {
      this.b.set(paramRect1);
      this.d.set(paramRect1);
      paramRect1 = this.d;
      int i = this.e;
      paramRect1.inset(-i, -i);
      this.c.set(paramRect2);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int k = (int)paramMotionEvent.getX();
      int m = (int)paramMotionEvent.getY();
      int i = paramMotionEvent.getAction();
      int j = 1;
      boolean bool2 = false;
      switch (i)
      {
      default: 
        break;
      case 3: 
        bool1 = this.f;
        this.f = false;
        i = j;
        break;
      case 1: 
      case 2: 
        boolean bool3 = this.f;
        bool1 = bool3;
        i = j;
        if (!bool3) {
          break label153;
        }
        bool1 = bool3;
        i = j;
        if (this.d.contains(k, m)) {
          break label153;
        }
        i = 0;
        bool1 = bool3;
        break;
      case 0: 
        if (this.b.contains(k, m))
        {
          this.f = true;
          bool1 = true;
          i = j;
        }
        break;
      }
      boolean bool1 = false;
      i = j;
      label153:
      if (bool1)
      {
        if ((i != 0) && (!this.c.contains(k, m))) {
          paramMotionEvent.setLocation(this.a.getWidth() / 2, this.a.getHeight() / 2);
        } else {
          paramMotionEvent.setLocation(k - this.c.left, m - this.c.top);
        }
        bool2 = this.a.dispatchTouchEvent(paramMotionEvent);
      }
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */