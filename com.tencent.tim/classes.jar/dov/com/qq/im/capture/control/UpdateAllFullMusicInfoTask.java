package dov.com.qq.im.capture.control;

import axov;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UpdateAllFullMusicInfoTask
  extends ParallGroup
{
  private ArrayList<FlowMusic> FP;
  private ArrayList<FlowMusic> FQ = new ArrayList();
  private List<FlowMusic> Ne = new ArrayList();
  private QIMMusicConfigManager a;
  
  public UpdateAllFullMusicInfoTask()
  {
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)axov.a(2));
  }
  
  private void dcD()
  {
    Object localObject = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.h.query(FlowMusic.class);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      this.FP = new ArrayList((Collection)localObject);
    }
    for (int i = this.FP.size(); this.FP != null; i = 0)
    {
      localObject = this.FP.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FlowMusic localFlowMusic = (FlowMusic)((Iterator)localObject).next();
        if (localFlowMusic.albumUrl == null) {
          this.Ne.add(localFlowMusic);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpdateAllFullMusicInfoTask", 2, "load db, has load local, size=" + i);
    }
  }
  
  private void eNG()
  {
    if (!this.FQ.isEmpty())
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.h.getTransaction();
      try
      {
        localEntityTransaction.begin();
        Iterator localIterator = this.FQ.iterator();
        while (localIterator.hasNext())
        {
          FlowMusic localFlowMusic = (FlowMusic)localIterator.next();
          this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.h.update(localFlowMusic);
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
      localEntityTransaction.end();
    }
    if (this.FP != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.bH(4, true, this.FP);
    }
  }
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    try
    {
      if ((paramAsyncStep instanceof GetSingleFullMusicInfoTask))
      {
        FlowMusic localFlowMusic = ((GetSingleFullMusicInfoTask)paramAsyncStep).a;
        if ((localFlowMusic != null) && (((GetSingleFullMusicInfoTask)paramAsyncStep).b != null))
        {
          localFlowMusic.albumUrl = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.albumUrl;
          localFlowMusic.url = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.url;
          localFlowMusic.size = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.size;
          localFlowMusic.playable = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.playable;
          this.FQ.add(localFlowMusic);
        }
      }
      paramInt = this.cyC - 1;
      this.cyC = paramInt;
      if (paramInt == 0)
      {
        eNG();
        setResult(7);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep);
      return;
    }
    finally {}
  }
  
  public int od()
  {
    this.cyC = this.Ne.size();
    if (!this.Ne.isEmpty())
    {
      Iterator localIterator = this.Ne.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (FlowMusic)localIterator.next();
          if (this.mResult != 8) {}
        }
        else
        {
          return 2;
        }
        Object localObject = new GetSingleFullMusicInfoTask((FlowMusic)localObject, null);
        ((AsyncStep)localObject).a = this;
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b((AsyncStep)localObject);
      }
    }
    eNG();
    return 7;
  }
  
  public void onCreate()
  {
    dcD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.UpdateAllFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */