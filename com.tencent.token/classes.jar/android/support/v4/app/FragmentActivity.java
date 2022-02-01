package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.token.av;
import com.tencent.token.av.b;
import com.tencent.token.az;
import com.tencent.token.bl;
import com.tencent.token.bx;
import com.tencent.token.bx.a;
import com.tencent.token.bx.b;
import com.tencent.token.bx.c;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.ce;
import com.tencent.token.cf;
import com.tencent.token.cg;
import com.tencent.token.cl;
import com.tencent.token.cs;
import com.tencent.token.ea;
import com.tencent.token.ek;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class FragmentActivity
  extends ca
  implements bx.a, bx.c
{
  static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
  static final String FRAGMENTS_TAG = "android:support:fragments";
  static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
  static final int MSG_REALLY_STOPPED = 1;
  static final int MSG_RESUME_PENDING = 2;
  static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
  static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
  private static final String TAG = "FragmentActivity";
  boolean mCreated;
  final cc mFragments = new cc(new a());
  public final Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        super.handleMessage(paramAnonymousMessage);
        return;
      case 2: 
        FragmentActivity.this.onResumeFragments();
        FragmentActivity.this.mFragments.b();
        return;
      }
      if (FragmentActivity.this.mStopped)
      {
        FragmentActivity.this.doReallyStop(false);
        return;
      }
    }
  };
  cl mLoaderManager;
  int mNextCandidateRequestIndex;
  ek<String> mPendingFragmentActivityResults;
  boolean mReallyStopped = true;
  boolean mRequestedPermissionsFromFragment;
  boolean mResumed;
  boolean mRetaining;
  boolean mStopped = true;
  private bl mViewModelStore;
  
  private int allocateRequestIndex(Fragment paramFragment)
  {
    if (this.mPendingFragmentActivityResults.b() < 65534)
    {
      for (;;)
      {
        ek localek = this.mPendingFragmentActivityResults;
        i = this.mNextCandidateRequestIndex;
        if (localek.a) {
          localek.a();
        }
        if (ea.a(localek.b, localek.d, i) < 0) {
          break;
        }
        this.mNextCandidateRequestIndex = ((this.mNextCandidateRequestIndex + 1) % 65534);
      }
      int i = this.mNextCandidateRequestIndex;
      this.mPendingFragmentActivityResults.a(i, paramFragment.g);
      this.mNextCandidateRequestIndex = ((this.mNextCandidateRequestIndex + 1) % 65534);
      return i;
    }
    throw new IllegalStateException("Too many pending Fragment activity results.");
  }
  
  private void markFragmentsCreated()
  {
    while (markState(getSupportFragmentManager(), av.b.c)) {}
  }
  
  private static boolean markState(ce paramce, av.b paramb)
  {
    paramce = paramce.d().iterator();
    boolean bool1 = false;
    while (paramce.hasNext())
    {
      Object localObject = (Fragment)paramce.next();
      if (localObject != null)
      {
        boolean bool2 = bool1;
        if (((Fragment)localObject).getLifecycle().a().a(av.b.d))
        {
          ((Fragment)localObject).U.a(paramb);
          bool2 = true;
        }
        localObject = ((Fragment)localObject).u;
        bool1 = bool2;
        if (localObject != null) {
          bool1 = bool2 | markState((ce)localObject, paramb);
        }
      }
    }
    return bool1;
  }
  
  public final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.mFragments.a.f.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  void doReallyStop(boolean paramBoolean)
  {
    if (!this.mReallyStopped)
    {
      this.mReallyStopped = true;
      this.mRetaining = paramBoolean;
      this.mHandler.removeMessages(1);
      onReallyStop();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("  ");
    localObject = ((StringBuilder)localObject).toString();
    paramPrintWriter.print((String)localObject);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.mCreated);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.mReallyStopped);
    cl localcl = this.mLoaderManager;
    if (localcl != null) {
      localcl.a((String)localObject, paramPrintWriter);
    }
    this.mFragments.a.f.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public Object getLastCustomNonConfigurationInstance()
  {
    b localb = (b)getLastNonConfigurationInstance();
    if (localb != null) {
      return localb.a;
    }
    return null;
  }
  
  public av getLifecycle()
  {
    return super.getLifecycle();
  }
  
  public ce getSupportFragmentManager()
  {
    return this.mFragments.a.f;
  }
  
  public cl getSupportLoaderManager()
  {
    cl localcl = this.mLoaderManager;
    if (localcl != null) {
      return localcl;
    }
    this.mLoaderManager = new LoaderManagerImpl(this, getViewModelStore());
    return this.mLoaderManager;
  }
  
  public bl getViewModelStore()
  {
    if (getApplication() != null)
    {
      if (this.mViewModelStore == null) {
        this.mViewModelStore = new bl();
      }
      return this.mViewModelStore;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mFragments.a();
    int i = paramInt1 >> 16;
    if (i != 0)
    {
      paramInt1 = i - 1;
      paramIntent = (String)this.mPendingFragmentActivityResults.a(paramInt1);
      this.mPendingFragmentActivityResults.b(paramInt1);
      if (paramIntent == null) {
        return;
      }
      this.mFragments.a(paramIntent);
      return;
    }
    bx.b localb = bx.a();
    if ((localb != null) && (localb.b())) {
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onBackPressed()
  {
    cf localcf = this.mFragments.a.f;
    boolean bool = localcf.e();
    if ((bool) && (Build.VERSION.SDK_INT <= 25)) {
      return;
    }
    if ((bool) || (!localcf.c())) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.a();
    this.mFragments.a.f.a(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject1 = this.mFragments;
    Object localObject2 = ((cc)localObject1).a.f;
    Object localObject3 = ((cc)localObject1).a;
    Object localObject4 = ((cc)localObject1).a;
    localObject1 = null;
    ((cf)localObject2).a((cd)localObject3, (cb)localObject4, null);
    super.onCreate(paramBundle);
    localObject4 = (b)getLastNonConfigurationInstance();
    if (localObject4 != null) {
      this.mViewModelStore = ((b)localObject4).b;
    }
    if (paramBundle != null)
    {
      localObject2 = paramBundle.getParcelable("android:support:fragments");
      localObject3 = this.mFragments;
      if (localObject4 != null) {
        localObject1 = ((b)localObject4).c;
      }
      ((cc)localObject3).a.f.a((Parcelable)localObject2, (cg)localObject1);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        this.mNextCandidateRequestIndex = paramBundle.getInt("android:support:next_request_index");
        localObject1 = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if ((localObject1 != null) && (paramBundle != null) && (localObject1.length == paramBundle.length))
        {
          this.mPendingFragmentActivityResults = new ek(localObject1.length);
          int i = 0;
          while (i < localObject1.length)
          {
            this.mPendingFragmentActivityResults.a(localObject1[i], paramBundle[i]);
            i += 1;
          }
        }
      }
    }
    if (this.mPendingFragmentActivityResults == null)
    {
      this.mPendingFragmentActivityResults = new ek();
      this.mNextCandidateRequestIndex = 0;
    }
    this.mFragments.a.f.k();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
      cc localcc = this.mFragments;
      MenuInflater localMenuInflater = getMenuInflater();
      return bool | localcc.a.f.a(paramMenu, localMenuInflater);
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    doReallyStop(false);
    bl localbl = this.mViewModelStore;
    if ((localbl != null) && (!this.mRetaining)) {
      localbl.a();
    }
    this.mFragments.a.f.p();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.mFragments.a.f.q();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    if (paramInt != 0)
    {
      if (paramInt != 6) {
        return false;
      }
      return this.mFragments.a.f.b(paramMenuItem);
    }
    return this.mFragments.a.f.a(paramMenuItem);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    this.mFragments.a.f.a(paramBoolean);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.mFragments.a();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0) {
      this.mFragments.a.f.b(paramMenu);
    }
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mResumed = false;
    if (this.mHandler.hasMessages(2))
    {
      this.mHandler.removeMessages(2);
      onResumeFragments();
    }
    this.mFragments.a.f.a(4);
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.mFragments.a.f.b(paramBoolean);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    this.mHandler.removeMessages(2);
    onResumeFragments();
    this.mFragments.b();
  }
  
  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null)) {
      return onPrepareOptionsPanel(paramView, paramMenu) | this.mFragments.a.f.a(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  void onReallyStop()
  {
    this.mFragments.a.f.a(2);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mFragments.a();
    paramInt = paramInt >> 16 & 0xFFFF;
    if (paramInt != 0)
    {
      paramInt -= 1;
      paramArrayOfString = (String)this.mPendingFragmentActivityResults.a(paramInt);
      this.mPendingFragmentActivityResults.b(paramInt);
      if (paramArrayOfString == null) {
        return;
      }
      this.mFragments.a(paramArrayOfString);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.mResumed = true;
    this.mFragments.b();
  }
  
  protected void onResumeFragments()
  {
    this.mFragments.a.f.n();
  }
  
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    if (this.mStopped) {
      doReallyStop(true);
    }
    Object localObject1 = onRetainCustomNonConfigurationInstance();
    Object localObject2 = this.mFragments.a.f;
    cf.a(((cf)localObject2).D);
    localObject2 = ((cf)localObject2).D;
    if ((localObject2 == null) && (this.mViewModelStore == null) && (localObject1 == null)) {
      return null;
    }
    b localb = new b();
    localb.a = localObject1;
    localb.b = this.mViewModelStore;
    localb.c = ((cg)localObject2);
    return localb;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    markFragmentsCreated();
    Object localObject = this.mFragments.a.f.i();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (this.mPendingFragmentActivityResults.b() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", this.mNextCandidateRequestIndex);
      localObject = new int[this.mPendingFragmentActivityResults.b()];
      String[] arrayOfString = new String[this.mPendingFragmentActivityResults.b()];
      int i = 0;
      while (i < this.mPendingFragmentActivityResults.b())
      {
        localObject[i] = this.mPendingFragmentActivityResults.c(i);
        arrayOfString[i] = ((String)this.mPendingFragmentActivityResults.d(i));
        i += 1;
      }
      paramBundle.putIntArray("android:support:request_indicies", (int[])localObject);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.mStopped = false;
    this.mReallyStopped = false;
    this.mHandler.removeMessages(1);
    if (!this.mCreated)
    {
      this.mCreated = true;
      this.mFragments.a.f.l();
    }
    this.mFragments.a();
    this.mFragments.b();
    this.mFragments.a.f.m();
  }
  
  public void onStateNotSaved()
  {
    this.mFragments.a();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mStopped = true;
    markFragmentsCreated();
    this.mHandler.sendEmptyMessage(1);
    this.mFragments.a.f.o();
  }
  
  void requestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt == -1)
    {
      bx.a(this, paramArrayOfString, paramInt);
      return;
    }
    checkForValidRequestCode(paramInt);
    try
    {
      this.mRequestedPermissionsFromFragment = true;
      bx.a(this, paramArrayOfString, (allocateRequestIndex(paramFragment) + 1 << 16) + (paramInt & 0xFFFF));
      return;
    }
    finally
    {
      this.mRequestedPermissionsFromFragment = false;
    }
  }
  
  public void setEnterSharedElementCallback(cs paramcs)
  {
    bx.a(this, paramcs);
  }
  
  public void setExitSharedElementCallback(cs paramcs)
  {
    bx.b(this, paramcs);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((!this.mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    this.mStartedActivityFromFragment = true;
    if (paramInt == -1) {}
    try
    {
      bx.a(this, paramIntent, -1, paramBundle);
      return;
    }
    finally
    {
      this.mStartedActivityFromFragment = false;
    }
    checkForValidRequestCode(paramInt);
    bx.a(this, paramIntent, (allocateRequestIndex(paramFragment) + 1 << 16) + (paramInt & 0xFFFF), paramBundle);
    this.mStartedActivityFromFragment = false;
  }
  
  public void startIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    this.mStartedIntentSenderFromFragment = true;
    if (paramInt1 == -1) {}
    try
    {
      bx.a(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    finally
    {
      this.mStartedIntentSenderFromFragment = false;
    }
    checkForValidRequestCode(paramInt1);
    bx.a(this, paramIntentSender, (allocateRequestIndex(paramFragment) + 1 << 16) + (paramInt1 & 0xFFFF), paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    this.mStartedIntentSenderFromFragment = false;
  }
  
  public void supportFinishAfterTransition()
  {
    bx.b(this);
  }
  
  @Deprecated
  public void supportInvalidateOptionsMenu()
  {
    invalidateOptionsMenu();
  }
  
  public void supportPostponeEnterTransition()
  {
    bx.c(this);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    bx.d(this);
  }
  
  public final void validateRequestPermissionsRequestCode(int paramInt)
  {
    if ((!this.mRequestedPermissionsFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
  }
  
  final class a
    extends cd<FragmentActivity>
  {
    public a()
    {
      super();
    }
    
    public final View a(int paramInt)
    {
      return FragmentActivity.this.findViewById(paramInt);
    }
    
    public final void a(Fragment paramFragment)
    {
      FragmentActivity.this.onAttachFragment(paramFragment);
    }
    
    public final void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      FragmentActivity.this.dump(paramString, null, paramPrintWriter, paramArrayOfString);
    }
    
    public final boolean a()
    {
      Window localWindow = FragmentActivity.this.getWindow();
      return (localWindow != null) && (localWindow.peekDecorView() != null);
    }
    
    public final boolean b()
    {
      return !FragmentActivity.this.isFinishing();
    }
    
    public final LayoutInflater c()
    {
      return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
    }
    
    public final void d()
    {
      FragmentActivity.this.supportInvalidateOptionsMenu();
    }
    
    public final boolean e()
    {
      return FragmentActivity.this.getWindow() != null;
    }
    
    public final int f()
    {
      Window localWindow = FragmentActivity.this.getWindow();
      if (localWindow == null) {
        return 0;
      }
      return localWindow.getAttributes().windowAnimations;
    }
  }
  
  static final class b
  {
    Object a;
    bl b;
    cg c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * JD-Core Version:    0.7.0.1
 */