import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class ambp
  implements wla.a
{
  private ConcurrentLinkedQueue<Long> I = new ConcurrentLinkedQueue();
  private String aUf;
  private Long ac;
  private ambp.b b;
  private ConcurrentHashMap<Long, ambp.a> gL;
  
  public ambp(String paramString)
  {
    this.aUf = paramString;
  }
  
  private aoko a()
  {
    if (!this.I.isEmpty())
    {
      this.ac = ((Long)this.I.peek());
      if ((this.ac != null) && (this.gL.containsKey(this.ac)))
      {
        ambp.a locala = (ambp.a)this.gL.get(this.ac);
        if (locala != null) {
          return locala.b();
        }
      }
    }
    return null;
  }
  
  private void a(aoko paramaoko)
  {
    if ((this.gL != null) && (this.gL.containsKey(Long.valueOf(paramaoko.uniseq))))
    {
      Object localObject = (ambp.a)this.gL.get(Long.valueOf(paramaoko.uniseq));
      if (localObject == null) {
        break label150;
      }
      View localView = ((ambp.a)localObject).getView();
      localObject = ((ambp.a)localObject).a();
      if ((localView != null) && (localObject != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("realHandleMessage1 status:").append(paramaoko.status).append(" ,uniseq").append(paramaoko.uniseq);
          QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
        }
        ((wla.a)localObject).a(localView, paramaoko, paramaoko.status, paramaoko.errorCode);
      }
    }
    else
    {
      return;
    }
    this.gL.remove(Long.valueOf(paramaoko.uniseq));
    return;
    label150:
    this.gL.remove(Long.valueOf(paramaoko.uniseq));
  }
  
  private void a(aoko paramaoko, boolean paramBoolean)
  {
    if (paramaoko == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.ac = ((Long)this.I.peek());
            if ((this.ac == null) || (paramaoko.uniseq != this.ac.longValue())) {
              break;
            }
            a(paramaoko);
          } while (paramaoko.status != 1003);
          this.I.remove(this.ac);
          this.gL.remove(this.ac);
          if (QLog.isColorLevel()) {
            QLog.d("OrderMediaMsgStatusCallback", 2, "remove callback:" + this.ac);
          }
          a(a(), false);
          return;
        } while ((!paramBoolean) || (!this.gL.containsKey(Long.valueOf(paramaoko.uniseq))));
        localObject = (ambp.a)this.gL.get(Long.valueOf(paramaoko.uniseq));
      } while (localObject == null);
      ((ambp.a)localObject).b(paramaoko);
    } while (!QLog.isColorLevel());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("needCache fileStatus:").append(paramaoko.status).append(" ,uniseq:").append(paramaoko.uniseq);
    QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
  }
  
  private void kX(long paramLong)
  {
    if ((this.gL != null) && (this.gL.containsKey(Long.valueOf(paramLong))))
    {
      localObject = (ambp.a)this.gL.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localView = ((ambp.a)localObject).getView();
        locala = ((ambp.a)localObject).a();
        localObject = ((ambp.a)localObject).b();
        if ((localView != null) && (locala != null) && (localObject != null))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("realHandleMessage2 status:").append(((aoko)localObject).status).append(" ,uniseq:").append(((aoko)localObject).uniseq);
            QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
          }
          ThreadManager.getUIHandler().post(new OrderMediaMsgStatusCallback.1(this, locala, localView, (aoko)localObject));
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      View localView;
      wla.a locala;
      StringBuilder localStringBuilder;
      return;
      this.gL.remove(Long.valueOf(paramLong));
      return;
    }
    QLog.d("OrderMediaMsgStatusCallback", 2, "CallbackWrapperMap not contain:" + paramLong);
  }
  
  private boolean p(long paramLong, int paramInt)
  {
    boolean bool1 = false;
    if (ambh.ld(paramInt))
    {
      this.I.remove(Long.valueOf(paramLong));
      if (this.b != null) {
        this.b.aS(paramLong, paramInt);
      }
      boolean bool2 = true;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleErrorMessage status:").append(paramInt).append(" ,uniseq:").append(paramLong);
        QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public int Y(long paramLong)
  {
    int i = 0;
    if (this.I.contains(Long.valueOf(paramLong)))
    {
      if (((Long)this.I.peek()).longValue() == paramLong) {
        i = 1;
      }
    }
    else {
      return i;
    }
    return 2;
  }
  
  public void a(ambp.b paramb)
  {
    this.b = paramb;
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    if (!this.I.contains(Long.valueOf(paramaoko.uniseq)))
    {
      a(paramaoko);
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "not exist in uniseqlist:" + paramaoko.uniseq);
      }
      return;
    }
    boolean bool = true;
    paramView = paramaoko;
    if (p(paramaoko.uniseq, paramInt1))
    {
      a(paramaoko);
      paramView = a();
      bool = false;
    }
    a(paramView, bool);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, View paramView, wla.a parama)
  {
    if ((paramQQAppInterface == null) || (this.I == null) || (!this.I.contains(Long.valueOf(paramLong)))) {
      return false;
    }
    if (this.gL == null) {
      this.gL = new ConcurrentHashMap();
    }
    Object localObject = wla.a(paramQQAppInterface);
    if (localObject != null) {
      ((wla)localObject).a(paramView, this);
    }
    int i;
    if (!this.gL.containsKey(Long.valueOf(paramLong)))
    {
      this.gL.put(Long.valueOf(paramLong), new ambp.a(paramView, parama));
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "callback add success:" + paramLong);
      }
      paramQQAppInterface = paramQQAppInterface.a().a(this.aUf, paramLong);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OrderMediaMsgStatusCallback", 2, "addCallback processor is null " + paramLong);
        }
        if (this.b == null) {
          break label505;
        }
        this.b.kW(paramLong);
        i = -1;
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          StringBuilder localStringBuilder = ((StringBuilder)localObject).append("addCallback uniseq:").append(paramLong).append(" ,status:").append(i).append(" ,view:");
          if (paramView != null) {
            break label511;
          }
          paramQQAppInterface = "";
          label252:
          paramView = localStringBuilder.append(paramQQAppInterface).append(" ,callback:");
          if (parama != null) {
            break label520;
          }
        }
      }
    }
    label520:
    for (paramQQAppInterface = "";; paramQQAppInterface = parama.toString())
    {
      paramView.append(paramQQAppInterface);
      QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
      return true;
      if ((paramQQAppInterface instanceof aojn))
      {
        paramQQAppInterface = (aojn)paramQQAppInterface;
        i = (int)paramQQAppInterface.hh();
        if (!p(paramLong, i))
        {
          this.ac = ((Long)this.I.peek());
          if ((paramLong != 0L) && (this.ac != null) && (paramLong != this.ac.longValue()))
          {
            if (parama != null)
            {
              parama.a(paramView, paramQQAppInterface.b(), i, paramQQAppInterface.errCode);
              localObject = (ambp.a)this.gL.get(Long.valueOf(paramLong));
              if (localObject != null) {
                ((ambp.a)localObject).b(paramQQAppInterface.b());
              }
            }
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("Not the first! status:").append(i).append(" ,uniseq:").append(paramLong);
              QLog.d("OrderMediaMsgStatusCallback", 2, paramQQAppInterface.toString());
            }
          }
        }
        break;
        paramQQAppInterface = (ambp.a)this.gL.get(Long.valueOf(paramLong));
        paramQQAppInterface.mView = new WeakReference(paramView);
        paramQQAppInterface.mCallback = new WeakReference(parama);
      }
      label505:
      i = -1;
      break;
      label511:
      paramQQAppInterface = paramView.toString();
      break label252;
    }
  }
  
  public void destroy()
  {
    if (this.gL != null)
    {
      this.gL.clear();
      this.gL = null;
    }
    this.I.clear();
    this.b = null;
  }
  
  public void kY(long paramLong)
  {
    if (!this.I.contains(Long.valueOf(paramLong))) {
      this.I.offer(Long.valueOf(paramLong));
    }
  }
  
  public void kZ(long paramLong)
  {
    if (this.I.contains(Long.valueOf(paramLong)))
    {
      this.I.remove(Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "removeUniseqFromOrderList " + paramLong);
      }
      kX(paramLong);
    }
  }
  
  class a
  {
    WeakReference<aoko> hJ;
    WeakReference<wla.a> mCallback;
    WeakReference<View> mView;
    
    public a(View paramView, wla.a parama)
    {
      this.mView = new WeakReference(paramView);
      this.mCallback = new WeakReference(parama);
    }
    
    public wla.a a()
    {
      return (wla.a)this.mCallback.get();
    }
    
    public aoko b()
    {
      if (this.hJ == null) {
        return null;
      }
      return (aoko)this.hJ.get();
    }
    
    public void b(aoko paramaoko)
    {
      this.hJ = new WeakReference(paramaoko);
    }
    
    public View getView()
    {
      return (View)this.mView.get();
    }
  }
  
  public static abstract interface b
  {
    public abstract void aS(long paramLong, int paramInt);
    
    public abstract void kW(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambp
 * JD-Core Version:    0.7.0.1
 */