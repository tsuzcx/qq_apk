import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.apollo.game.ApolloFragment;
import com.tencent.mobileqq.apollo.game.ApolloFragmentManager.1;
import com.tencent.mobileqq.apollo.game.ApolloFragmentManager.2;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class able
{
  public static able a;
  public static AtomicInteger aV = new AtomicInteger(0);
  public static Stack<ApolloFragment> h = new Stack();
  public static Stack<ApolloFragment> i = new Stack();
  private FragmentManager b;
  private Fragment c;
  private FragmentActivity e;
  private int mContainerId;
  
  public static able a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new able();
      }
      return a;
    }
    finally {}
  }
  
  public static void a(FragmentActivity paramFragmentActivity, Intent paramIntent)
  {
    Object localObject = new Bundle();
    if ((paramIntent != null) && (paramFragmentActivity != null))
    {
      paramIntent.putExtra("vasUsePreWebview", true);
      ((Bundle)localObject).putParcelable("intent", paramIntent);
    }
    try
    {
      ApolloWebViewFragment localApolloWebViewFragment = new ApolloWebViewFragment();
      paramIntent.putExtra("id", aV.getAndIncrement());
      localApolloWebViewFragment.setArguments((Bundle)localObject);
      localObject = paramFragmentActivity.getIntent();
      ((Intent)localObject).putExtras(paramIntent);
      localApolloWebViewFragment.bV(paramIntent.getExtras());
      localApolloWebViewFragment.bW(paramIntent.getExtras());
      paramFragmentActivity.setIntent((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloFragmentManager", 2, "[notifyViewChange] " + localApolloWebViewFragment.getCurrentUrl() + " " + localApolloWebViewFragment.getPageId());
      }
      paramIntent = paramFragmentActivity.getSupportFragmentManager();
      if (!localApolloWebViewFragment.isAdded()) {
        paramIntent.beginTransaction().add(2131367885, localApolloWebViewFragment).commitAllowingStateLoss();
      }
      paramIntent.beginTransaction().show(localApolloWebViewFragment).setCustomAnimations(2130772092, 2130772093).commit();
      if ((!paramFragmentActivity.isFinishing()) && ((paramFragmentActivity instanceof ApolloGameActivity)))
      {
        paramIntent = ((ApolloGameActivity)paramFragmentActivity).a();
        if (paramIntent != null) {
          paramIntent.b = localApolloWebViewFragment;
        }
        paramFragmentActivity.runOnUiThread(new ApolloFragmentManager.1(paramFragmentActivity, localApolloWebViewFragment));
      }
      return;
    }
    catch (Throwable paramFragmentActivity)
    {
      QLog.e("ApolloFragmentManager", 1, paramFragmentActivity, new Object[0]);
    }
  }
  
  private void b(Stack<ApolloFragment> paramStack)
  {
    if ((paramStack != null) && (paramStack.size() > 0) && (this.b != null))
    {
      FragmentTransaction localFragmentTransaction = this.b.beginTransaction();
      paramStack = paramStack.iterator();
      while (paramStack.hasNext())
      {
        Fragment localFragment = (Fragment)paramStack.next();
        if ((localFragment != null) && (localFragment.isAdded()) && ((this.c == null) || (!localFragment.equals(this.c)))) {
          localFragmentTransaction.hide(localFragment);
        }
      }
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  /* Error */
  public void a(Intent paramIntent, java.lang.Class<? extends ApolloFragment> paramClass)
  {
    // Byte code:
    //   0: getstatic 31	able:i	Ljava/util/Stack;
    //   3: invokevirtual 241	java/util/Stack:empty	()Z
    //   6: ifeq +34 -> 40
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +41 -> 53
    //   15: getstatic 29	able:h	Ljava/util/Stack;
    //   18: aload_3
    //   19: invokevirtual 245	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: pop
    //   23: aload_1
    //   24: ifnull +11 -> 35
    //   27: aload_3
    //   28: aload_1
    //   29: invokevirtual 97	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   32: invokevirtual 248	com/tencent/mobileqq/apollo/game/ApolloFragment:bV	(Landroid/os/Bundle;)V
    //   35: aload_0
    //   36: invokevirtual 251	able:cCG	()V
    //   39: return
    //   40: getstatic 31	able:i	Ljava/util/Stack;
    //   43: invokevirtual 254	java/util/Stack:pop	()Ljava/lang/Object;
    //   46: checkcast 247	com/tencent/mobileqq/apollo/game/ApolloFragment
    //   49: astore_3
    //   50: goto -39 -> 11
    //   53: ldc 2
    //   55: monitorenter
    //   56: new 52	android/os/Bundle
    //   59: dup
    //   60: invokespecial 53	android/os/Bundle:<init>	()V
    //   63: astore_3
    //   64: aload_1
    //   65: ifnull +90 -> 155
    //   68: aload_1
    //   69: ldc 55
    //   71: iconst_1
    //   72: invokevirtual 61	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   75: pop
    //   76: aload_3
    //   77: ldc 63
    //   79: aload_1
    //   80: invokevirtual 67	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   83: aload_2
    //   84: invokevirtual 259	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   87: checkcast 247	com/tencent/mobileqq/apollo/game/ApolloFragment
    //   90: astore_2
    //   91: aload_1
    //   92: ldc 72
    //   94: getstatic 38	able:aV	Ljava/util/concurrent/atomic/AtomicInteger;
    //   97: invokevirtual 76	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   100: invokevirtual 79	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   103: pop
    //   104: aload_2
    //   105: aload_3
    //   106: invokevirtual 260	com/tencent/mobileqq/apollo/game/ApolloFragment:setArguments	(Landroid/os/Bundle;)V
    //   109: getstatic 29	able:h	Ljava/util/Stack;
    //   112: aload_2
    //   113: invokevirtual 245	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload_0
    //   118: getfield 47	able:e	Landroid/support/v4/app/FragmentActivity;
    //   121: invokevirtual 89	android/support/v4/app/FragmentActivity:getIntent	()Landroid/content/Intent;
    //   124: astore_3
    //   125: aload_3
    //   126: aload_1
    //   127: invokevirtual 93	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   130: pop
    //   131: aload_2
    //   132: aload_1
    //   133: invokevirtual 97	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   136: invokevirtual 248	com/tencent/mobileqq/apollo/game/ApolloFragment:bV	(Landroid/os/Bundle;)V
    //   139: aload_2
    //   140: aload_1
    //   141: invokevirtual 97	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   144: invokevirtual 261	com/tencent/mobileqq/apollo/game/ApolloFragment:bW	(Landroid/os/Bundle;)V
    //   147: aload_0
    //   148: getfield 47	able:e	Landroid/support/v4/app/FragmentActivity;
    //   151: aload_3
    //   152: invokevirtual 107	android/support/v4/app/FragmentActivity:setIntent	(Landroid/content/Intent;)V
    //   155: ldc 2
    //   157: monitorexit
    //   158: goto -123 -> 35
    //   161: astore_1
    //   162: ldc 2
    //   164: monitorexit
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: ldc 115
    //   170: iconst_1
    //   171: aload_1
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   179: goto -24 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	able
    //   0	182	1	paramIntent	Intent
    //   0	182	2	paramClass	java.lang.Class<? extends ApolloFragment>
    //   10	142	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	64	161	finally
    //   68	83	161	finally
    //   83	155	161	finally
    //   155	158	161	finally
    //   162	165	161	finally
    //   168	179	161	finally
    //   83	155	167	java/lang/Throwable
  }
  
  public void a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    if (paramFragmentActivity != null)
    {
      this.mContainerId = paramInt;
      this.e = paramFragmentActivity;
      this.b = this.e.getSupportFragmentManager();
      return;
    }
    QLog.e("ApolloFragmentManager", 1, "[init] activity null");
  }
  
  public void a(Stack<ApolloFragment> paramStack)
  {
    if ((paramStack != null) && (paramStack.size() > 0))
    {
      paramStack = paramStack.iterator();
      while (paramStack.hasNext())
      {
        ApolloFragment localApolloFragment = (ApolloFragment)paramStack.next();
        if ((localApolloFragment.isAdded()) && (this.b != null)) {
          this.b.beginTransaction().remove(localApolloFragment).commit();
        }
      }
    }
  }
  
  public void cCG()
  {
    try
    {
      if ((this.b != null) && (!h.isEmpty()))
      {
        ApolloFragment localApolloFragment = (ApolloFragment)h.peek();
        if (localApolloFragment != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloFragmentManager", 2, "[notifyViewChange] " + localApolloFragment.getCurrentUrl() + " " + localApolloFragment.getPageId());
          }
          if (!localApolloFragment.isAdded()) {
            this.b.beginTransaction().add(this.mContainerId, localApolloFragment).commitAllowingStateLoss();
          }
          this.b.beginTransaction().show(localApolloFragment).setCustomAnimations(2130772092, 2130772093).commit();
          this.c = localApolloFragment;
          b(i);
          b(h);
          if ((this.e != null) && (!this.e.isFinishing()) && ((this.e instanceof ApolloGameActivity))) {
            this.e.runOnUiThread(new ApolloFragmentManager.2(this, localApolloFragment));
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloFragmentManager", 1, "[notifyViewChange]", localThrowable);
    }
  }
  
  public void cZ(Intent paramIntent)
  {
    if (h.size() > 1)
    {
      localApolloFragment = (ApolloFragment)h.pop();
      if (localApolloFragment != null)
      {
        localApolloFragment.bU(null);
        i.push(localApolloFragment);
      }
      localApolloFragment = (ApolloFragment)h.peek();
      if (localApolloFragment != null)
      {
        localBundle = new Bundle();
        if (paramIntent != null)
        {
          localBundle.putParcelable("intent", paramIntent);
          localApolloFragment.bV(paramIntent.getExtras());
        }
      }
      cCG();
    }
    while (!QLog.isColorLevel())
    {
      ApolloFragment localApolloFragment;
      Bundle localBundle;
      return;
    }
    QLog.d("ApolloFragmentManager", 2, "[back] reach bottom");
  }
  
  public void destroy()
  {
    a(h);
    a(i);
    h.clear();
    i.clear();
    abll.a().destroy();
  }
  
  public int zD()
  {
    if (h == null) {
      return 0;
    }
    return h.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     able
 * JD-Core Version:    0.7.0.1
 */