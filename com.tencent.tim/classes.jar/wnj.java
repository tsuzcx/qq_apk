import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.a;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.util.List;

public class wnj
  extends AIOAnimationConatiner.a
{
  private wnt jdField_a_of_type_Wnt;
  private wnw jdField_a_of_type_Wnw;
  private AIOAnimationConatiner.a b;
  
  public wnj(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private boolean d(Object... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVarArgs.length == 4)
    {
      bool1 = bool2;
      if (this.c != null)
      {
        bool1 = bool2;
        if (this.l != null)
        {
          if (this.b == null) {
            this.b = new adxx(0, this.c, this.l);
          }
          bool1 = this.b.c(paramVarArgs);
        }
      }
    }
    return bool1;
  }
  
  private boolean e(Object... paramVarArgs)
  {
    boolean bool1 = ((Boolean)paramVarArgs[4]).booleanValue();
    if ((this.jdField_a_of_type_Wnt != null) && ((paramVarArgs[5] != null) || (bool1))) {
      this.jdField_a_of_type_Wnt.yE(true);
    }
    boolean bool2 = false;
    bool1 = bool2;
    if (this.c != null)
    {
      bool1 = bool2;
      if (this.l != null)
      {
        this.jdField_a_of_type_Wnt = new wnt(this.priority, this.c, this.l);
        bool1 = this.jdField_a_of_type_Wnt.c(paramVarArgs);
      }
    }
    return bool1;
  }
  
  private boolean f(Object... paramVarArgs)
  {
    Pair localPair = null;
    if (paramVarArgs.length == 3) {
      localPair = (Pair)paramVarArgs[2];
    }
    if ((localPair == null) || (localPair.first == null)) {
      return false;
    }
    if (((adxp.a)localPair.first).g.cKC == 1)
    {
      if (this.jdField_a_of_type_Wnw != null) {
        this.jdField_a_of_type_Wnw.bZS();
      }
      this.jdField_a_of_type_Wnw = new wnw(this.priority, this.c, this.l);
      return this.jdField_a_of_type_Wnw.c(paramVarArgs);
    }
    return false;
  }
  
  public void Cp(int paramInt)
  {
    if (this.jdField_a_of_type_Wnw != null) {
      this.jdField_a_of_type_Wnw.Cp(paramInt);
    }
    if (this.b != null) {
      this.b.Cp(paramInt);
    }
    if (this.jdField_a_of_type_Wnt != null) {
      this.jdField_a_of_type_Wnt.Cp(paramInt);
    }
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = false;
    if (this.b != null) {}
    for (boolean bool2 = this.b.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);; bool2 = false)
    {
      if (this.jdField_a_of_type_Wnw != null) {
        if ((!this.jdField_a_of_type_Wnw.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4)) && (!bool2)) {}
      }
      for (bool1 = true;; bool1 = bool2)
      {
        if (this.jdField_a_of_type_Wnt != null) {
          bool1 = this.jdField_a_of_type_Wnt.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        }
        return bool1;
      }
    }
  }
  
  public boolean c(Object... paramVarArgs)
  {
    if (paramVarArgs.length >= 2) {}
    for (;;)
    {
      int i;
      try
      {
        long l = ((Long)paramVarArgs[1]).longValue();
        if ((this.l != null) && (this.l.getAdapter() != null) && (l > 0L))
        {
          ListAdapter localListAdapter = this.l.getAdapter();
          i = localListAdapter.getCount() - 1;
          if (i < 0) {
            break label243;
          }
          Object localObject1 = localListAdapter.getItem(i);
          if ((localObject1 instanceof ChatMessage))
          {
            localObject1 = (ChatMessage)localObject1;
            if (((ChatMessage)localObject1).uniseq == l)
            {
              if (localObject1 == null) {
                break label162;
              }
              localObject1 = EmojiStickerManager.a().c((MessageRecord)localObject1);
              if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
                break label162;
              }
              if (QLog.isColorLevel()) {
                QLog.i("BubbleAnimation", 2, "contain sticker, so stop bubble animation!");
              }
              return false;
            }
          }
          i -= 1;
          continue;
        }
        i = ((Integer)paramVarArgs[0]).intValue();
      }
      catch (Exception localException)
      {
        QLog.e("BubbleAnimation", 1, "", localException);
      }
      label162:
      boolean bool;
      if ((i == 0) || (i == 1) || (i == 6)) {
        bool = f(paramVarArgs);
      }
      for (;;)
      {
        return bool;
        if ((i == 5) || (i == 3) || (i == 2)) {
          bool = d(paramVarArgs);
        } else if (i == 4) {
          bool = e(paramVarArgs);
        } else {
          bool = false;
        }
      }
      label243:
      Object localObject2 = null;
    }
  }
  
  public boolean gp(int paramInt)
  {
    return true;
  }
  
  public void pause()
  {
    if (this.jdField_a_of_type_Wnt != null) {
      this.jdField_a_of_type_Wnt.pause();
    }
  }
  
  public void resume()
  {
    if (this.jdField_a_of_type_Wnt != null) {
      this.jdField_a_of_type_Wnt.resume();
    }
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_Wnw != null) {
      this.jdField_a_of_type_Wnw.bZS();
    }
    if (this.b != null) {
      this.b.stop();
    }
    if (this.jdField_a_of_type_Wnt != null) {
      this.jdField_a_of_type_Wnt.yE(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnj
 * JD-Core Version:    0.7.0.1
 */