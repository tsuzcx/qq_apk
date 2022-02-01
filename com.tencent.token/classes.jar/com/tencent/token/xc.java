package com.tencent.token;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public final class xc
{
  static Handler a;
  static boolean b = true;
  
  static void a(long paramLong1, long paramLong2, PendingIntent paramPendingIntent)
  {
    paramPendingIntent = a.obtainMessage(7, paramPendingIntent);
    long l = SystemClock.uptimeMillis();
    paramLong1 -= System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder("[post] nowUp:");
    localStringBuilder.append(l);
    localStringBuilder.append(", diff:");
    localStringBuilder.append(paramLong1);
    auq.c(localStringBuilder.toString());
    int i = (int)paramLong2;
    if (i == paramLong2) {
      paramPendingIntent.arg1 = i;
    } else {
      auq.a("[so big]not support yet interval:".concat(String.valueOf(paramLong2)));
    }
    a.sendMessageAtTime(paramPendingIntent, l + paramLong1);
  }
  
  static void a(PendingIntent paramPendingIntent)
  {
    a.removeMessages(7, paramPendingIntent);
  }
  
  @SuppressLint({"PrivateApi"})
  public static void a(Context paramContext)
  {
    try
    {
      Object localObject1 = new HandlerThread("al-sm");
      ((HandlerThread)localObject1).start();
      a = new Handler(((HandlerThread)localObject1).getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          if (paramAnonymousMessage.what != 7) {
            return;
          }
          auq.c("[alarm] doing");
          if (paramAnonymousMessage.arg1 > 0)
          {
            StringBuilder localStringBuilder = new StringBuilder("[repeat msg] inv:");
            localStringBuilder.append(paramAnonymousMessage.arg1);
            localStringBuilder.append(", time:");
            localStringBuilder.append(paramAnonymousMessage.arg2);
            auq.c(localStringBuilder.toString());
          }
          try
          {
            ((PendingIntent)paramAnonymousMessage.obj).send();
          }
          catch (PendingIntent.CanceledException localCanceledException)
          {
            auq.a("cancel", localCanceledException);
          }
          if (paramAnonymousMessage.arg1 > 0)
          {
            Message localMessage = obtainMessage(7, paramAnonymousMessage.obj);
            paramAnonymousMessage.arg2 += 1;
            localMessage.arg1 = paramAnonymousMessage.arg1;
            sendMessageDelayed(localMessage, paramAnonymousMessage.arg1);
          }
        }
      };
      localObject1 = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (Map)((Field)localObject1).get(null);
      Object localObject2 = (IBinder)((Map)localObject1).get("alarm");
      auq.c("original:".concat(String.valueOf(localObject2)));
      ((Map)localObject1).put("alarm", new IBinder()
      {
        public final void dump(FileDescriptor paramAnonymousFileDescriptor, String[] paramAnonymousArrayOfString)
        {
          this.a.dump(paramAnonymousFileDescriptor, paramAnonymousArrayOfString);
        }
        
        public final void dumpAsync(FileDescriptor paramAnonymousFileDescriptor, String[] paramAnonymousArrayOfString)
        {
          this.a.dumpAsync(paramAnonymousFileDescriptor, paramAnonymousArrayOfString);
        }
        
        public final String getInterfaceDescriptor()
        {
          return this.a.getInterfaceDescriptor();
        }
        
        public final boolean isBinderAlive()
        {
          return this.a.isBinderAlive();
        }
        
        public final void linkToDeath(IBinder.DeathRecipient paramAnonymousDeathRecipient, int paramAnonymousInt)
        {
          this.a.linkToDeath(paramAnonymousDeathRecipient, paramAnonymousInt);
        }
        
        public final boolean pingBinder()
        {
          return this.a.pingBinder();
        }
        
        public final IInterface queryLocalInterface(String paramAnonymousString)
        {
          return this.a.queryLocalInterface(paramAnonymousString);
        }
        
        public final boolean transact(int paramAnonymousInt1, Parcel paramAnonymousParcel1, Parcel paramAnonymousParcel2, int paramAnonymousInt2)
        {
          auq.c("transact code:".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == 1) {
            try
            {
              auq.c("pos:".concat(String.valueOf(paramAnonymousParcel1.dataPosition())));
              paramAnonymousParcel1.setDataPosition(0);
              paramAnonymousParcel1.readInt();
              paramAnonymousParcel1.readInt();
              paramAnonymousParcel1.readString();
              paramAnonymousParcel1.readString();
              paramAnonymousInt1 = paramAnonymousParcel1.readInt();
              long l1 = paramAnonymousParcel1.readLong();
              paramAnonymousParcel1.readLong();
              long l2 = paramAnonymousParcel1.readLong();
              paramAnonymousParcel1.readInt();
              paramAnonymousParcel1.readInt();
              paramAnonymousParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramAnonymousParcel1);
              paramAnonymousParcel2 = new StringBuilder("[set] type:");
              paramAnonymousParcel2.append(paramAnonymousInt1);
              paramAnonymousParcel2.append(" trigger:");
              paramAnonymousParcel2.append(l1);
              paramAnonymousParcel2.append(" padding intent:");
              paramAnonymousParcel2.append(paramAnonymousParcel1);
              auq.c(paramAnonymousParcel2.toString());
              xc.a(l1, l2, paramAnonymousParcel1);
              return false;
            }
            catch (Throwable paramAnonymousParcel1)
            {
              auq.a("transact err", paramAnonymousParcel1);
              return false;
            }
          }
          if (paramAnonymousInt1 == 4) {
            try
            {
              paramAnonymousParcel1.setDataPosition(0);
              paramAnonymousParcel1.readInt();
              paramAnonymousParcel1.readInt();
              paramAnonymousParcel2 = paramAnonymousParcel1.readString();
              paramAnonymousParcel1.readInt();
              paramAnonymousParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramAnonymousParcel1);
              StringBuilder localStringBuilder = new StringBuilder("[remove] in:");
              localStringBuilder.append(paramAnonymousParcel2);
              localStringBuilder.append(" intent:");
              localStringBuilder.append(paramAnonymousParcel1);
              auq.c(localStringBuilder.toString());
              xc.a(paramAnonymousParcel1);
              return false;
            }
            catch (Throwable paramAnonymousParcel1)
            {
              auq.a("transact err", paramAnonymousParcel1);
            }
          }
          return false;
        }
        
        public final boolean unlinkToDeath(IBinder.DeathRecipient paramAnonymousDeathRecipient, int paramAnonymousInt)
        {
          return this.a.unlinkToDeath(paramAnonymousDeathRecipient, paramAnonymousInt);
        }
      });
      if (b)
      {
        localObject1 = Class.forName("android.app.IAlarmManager");
        localObject2 = ((Class)localObject1).getClassLoader();
        InvocationHandler local3 = new InvocationHandler()
        {
          public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
          {
            StringBuilder localStringBuilder = new StringBuilder("invoke method:");
            localStringBuilder.append(paramAnonymousMethod.getName());
            auq.c(localStringBuilder.toString());
            if ("set".equals(paramAnonymousMethod.getName())) {
              try
              {
                if ((paramAnonymousArrayOfObject.length >= 7) && ((paramAnonymousArrayOfObject[6] instanceof PendingIntent)))
                {
                  ((Integer)paramAnonymousArrayOfObject[1]).intValue();
                  xc.a(((Long)paramAnonymousArrayOfObject[2]).longValue(), ((Long)paramAnonymousArrayOfObject[4]).longValue(), (PendingIntent)paramAnonymousArrayOfObject[6]);
                }
                else
                {
                  auq.a("[set] not match api");
                }
              }
              catch (Throwable paramAnonymousObject)
              {
                auq.a("set err", paramAnonymousObject);
              }
            } else if (!"remove".equals(paramAnonymousMethod.getName())) {}
            try
            {
              if ((paramAnonymousArrayOfObject.length > 0) && ((paramAnonymousArrayOfObject[0] instanceof PendingIntent))) {
                xc.a((PendingIntent)paramAnonymousArrayOfObject[0]);
              } else {
                auq.a("[remove] not match api");
              }
            }
            catch (Throwable paramAnonymousObject)
            {
              label163:
              label207:
              break label163;
            }
            auq.a("remove e");
            break label207;
            if ("toString".equals(paramAnonymousMethod.getName()))
            {
              paramAnonymousMethod = new StringBuilder("IAlarmManager_");
              paramAnonymousMethod.append(System.identityHashCode(paramAnonymousObject));
              return paramAnonymousMethod.toString();
            }
            return null;
          }
        };
        localObject1 = Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { localObject1 }, local3);
        paramContext = (AlarmManager)paramContext.getSystemService("alarm");
        localObject2 = AlarmManager.class.getDeclaredField("mService");
        ((Field)localObject2).setAccessible(true);
        ((Field)localObject2).set(paramContext, localObject1);
      }
      auq.c("hook finish");
      return;
    }
    catch (Throwable paramContext)
    {
      auq.a("hook err", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xc
 * JD-Core Version:    0.7.0.1
 */