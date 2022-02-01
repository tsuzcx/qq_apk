package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.b;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.token.gf;
import com.tencent.token.gp.a;
import com.tencent.token.gp.j;
import java.lang.ref.WeakReference;

final class AlertController
{
  NestedScrollView A;
  int B = 0;
  Drawable C;
  ImageView D;
  TextView E;
  TextView F;
  View G;
  ListAdapter H;
  int I = -1;
  int J;
  int K;
  int L;
  int M;
  int N;
  int O;
  boolean P;
  int Q = 0;
  Handler R;
  final View.OnClickListener S = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == AlertController.this.o) && (AlertController.this.q != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.q);
      } else if ((paramAnonymousView == AlertController.this.s) && (AlertController.this.u != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.u);
      } else if ((paramAnonymousView == AlertController.this.w) && (AlertController.this.y != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.y);
      } else {
        paramAnonymousView = null;
      }
      if (paramAnonymousView != null) {
        paramAnonymousView.sendToTarget();
      }
      AlertController.this.R.obtainMessage(1, AlertController.this.b).sendToTarget();
    }
  };
  final Context a;
  final AppCompatDialog b;
  final Window c;
  final int d;
  CharSequence e;
  CharSequence f;
  ListView g;
  View h;
  int i;
  int j;
  int k;
  int l;
  int m;
  boolean n = false;
  Button o;
  CharSequence p;
  Message q;
  Drawable r;
  Button s;
  CharSequence t;
  Message u;
  Drawable v;
  Button w;
  CharSequence x;
  Message y;
  Drawable z;
  
  public AlertController(Context paramContext, AppCompatDialog paramAppCompatDialog, Window paramWindow)
  {
    this.a = paramContext;
    this.b = paramAppCompatDialog;
    this.c = paramWindow;
    this.R = new b(paramAppCompatDialog);
    paramContext = paramContext.obtainStyledAttributes(null, gp.j.AlertDialog, gp.a.alertDialogStyle, 0);
    this.J = paramContext.getResourceId(gp.j.AlertDialog_android_layout, 0);
    this.K = paramContext.getResourceId(gp.j.AlertDialog_buttonPanelSideLayout, 0);
    this.L = paramContext.getResourceId(gp.j.AlertDialog_listLayout, 0);
    this.M = paramContext.getResourceId(gp.j.AlertDialog_multiChoiceItemLayout, 0);
    this.N = paramContext.getResourceId(gp.j.AlertDialog_singleChoiceItemLayout, 0);
    this.O = paramContext.getResourceId(gp.j.AlertDialog_listItemLayout, 0);
    this.P = paramContext.getBoolean(gp.j.AlertDialog_showTitle, true);
    this.d = paramContext.getDimensionPixelSize(gp.j.AlertDialog_buttonIconDimen, 0);
    paramContext.recycle();
    paramAppCompatDialog.a().c(1);
  }
  
  static ViewGroup a(View paramView1, View paramView2)
  {
    if (paramView1 == null)
    {
      paramView1 = paramView2;
      if ((paramView2 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView2).inflate();
      }
      return (ViewGroup)paramView1;
    }
    if (paramView2 != null)
    {
      ViewParent localViewParent = paramView2.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView2);
      }
    }
    paramView2 = paramView1;
    if ((paramView1 instanceof ViewStub)) {
      paramView2 = ((ViewStub)paramView1).inflate();
    }
    return (ViewGroup)paramView2;
  }
  
  static void a(View paramView1, View paramView2, View paramView3)
  {
    int i2 = 0;
    int i1;
    if (paramView2 != null)
    {
      if (paramView1.canScrollVertically(-1)) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      paramView2.setVisibility(i1);
    }
    if (paramView3 != null)
    {
      if (paramView1.canScrollVertically(1)) {
        i1 = i2;
      } else {
        i1 = 4;
      }
      paramView3.setVisibility(i1);
    }
  }
  
  static void a(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
  }
  
  static boolean a(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i1 = paramView.getChildCount();
    while (i1 > 0)
    {
      int i2 = i1 - 1;
      i1 = i2;
      if (a(paramView.getChildAt(i2))) {
        return true;
      }
    }
    return false;
  }
  
  public final void a(int paramInt)
  {
    this.C = null;
    this.B = paramInt;
    ImageView localImageView = this.D;
    if (localImageView != null)
    {
      if (paramInt != 0)
      {
        localImageView.setVisibility(0);
        this.D.setImageResource(this.B);
        return;
      }
      localImageView.setVisibility(8);
    }
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage, Drawable paramDrawable)
  {
    if (paramOnClickListener != null) {
      paramMessage = this.R.obtainMessage(paramInt, paramOnClickListener);
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Button does not exist");
    case -1: 
      this.p = paramCharSequence;
      this.q = paramMessage;
      this.r = paramDrawable;
      return;
    case -2: 
      this.t = paramCharSequence;
      this.u = paramMessage;
      this.v = paramDrawable;
      return;
    }
    this.x = paramCharSequence;
    this.y = paramMessage;
    this.z = paramDrawable;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    TextView localTextView = this.E;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public static class RecycleListView
    extends ListView
  {
    final int a;
    final int b;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, gp.j.RecycleListView);
      this.b = paramContext.getDimensionPixelOffset(gp.j.RecycleListView_paddingBottomNoButtons, -1);
      this.a = paramContext.getDimensionPixelOffset(gp.j.RecycleListView_paddingTopNoTitle, -1);
    }
  }
  
  public static final class a
  {
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean E = false;
    public boolean[] F;
    public boolean G;
    public boolean H;
    public int I = -1;
    public DialogInterface.OnMultiChoiceClickListener J;
    public Cursor K;
    public String L;
    public String M;
    public AdapterView.OnItemSelectedListener N;
    public boolean O = true;
    public final Context a;
    public final LayoutInflater b;
    public int c = 0;
    public Drawable d;
    public int e = 0;
    public CharSequence f;
    public View g;
    public CharSequence h;
    public CharSequence i;
    public Drawable j;
    public DialogInterface.OnClickListener k;
    public CharSequence l;
    public Drawable m;
    public DialogInterface.OnClickListener n;
    public CharSequence o;
    public Drawable p;
    public DialogInterface.OnClickListener q;
    public boolean r;
    public DialogInterface.OnCancelListener s;
    public DialogInterface.OnDismissListener t;
    public DialogInterface.OnKeyListener u;
    public CharSequence[] v;
    public ListAdapter w;
    public DialogInterface.OnClickListener x;
    public int y;
    public View z;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
      this.r = true;
      this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
  }
  
  static final class b
    extends Handler
  {
    private WeakReference<DialogInterface> a;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.a = new WeakReference(paramDialogInterface);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        switch (i)
        {
        default: 
          return;
        }
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.a.get(), paramMessage.what);
        return;
      }
      ((DialogInterface)paramMessage.obj).dismiss();
    }
  }
  
  static final class c
    extends ArrayAdapter<CharSequence>
  {
    public c(Context paramContext, int paramInt, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt, 16908308, paramArrayOfCharSequence);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController
 * JD-Core Version:    0.7.0.1
 */