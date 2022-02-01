package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import java.util.concurrent.ConcurrentLinkedQueue;
import qxl;
import qxn.a;
import qxo;
import ram;

public class SerialStepExecutor$1
  implements Runnable
{
  public SerialStepExecutor$1(qxl paramqxl) {}
  
  public void run()
  {
    if (qxl.a(this.this$0).size() == 0)
    {
      if (this.this$0.jdField_a_of_type_Qxn$a != null) {
        this.this$0.jdField_a_of_type_Qxn$a.done();
      }
      qxl.a(this.this$0, 2);
      this.this$0.completed();
      return;
    }
    this.this$0.jdField_a_of_type_Qxo = ((qxo)qxl.a(this.this$0).poll());
    if (this.this$0.jdField_a_of_type_Qxo == null)
    {
      if (this.this$0.jdField_a_of_type_Qxn$a != null) {
        this.this$0.jdField_a_of_type_Qxn$a.done();
      }
      qxl.a(this.this$0, 2);
      this.this$0.completed();
      return;
    }
    this.this$0.jdField_a_of_type_Qxo.dump();
    ram.d("Q.qqstory.home.SerialStepExecutor", "剩下step:" + qxl.a(this.this$0).size());
    this.this$0.jdField_a_of_type_Qxo.a(this.this$0);
    this.this$0.jdField_a_of_type_Qxo.a(this.this$0);
    if (this.this$0.param == null) {
      ram.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.this$0.jdField_a_of_type_Qxo.getKey() + ",return null result");
    }
    this.this$0.jdField_a_of_type_Qxo.an(this.this$0.param);
    this.this$0.jdField_a_of_type_Qxo.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */