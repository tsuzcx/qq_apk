package com.tencent.biz.qrcode;

import java.util.concurrent.atomic.AtomicBoolean;

class CodeMaskManager$2
  implements Runnable
{
  CodeMaskManager$2(CodeMaskManager paramCodeMaskManager, CodeMaskManager.PrepareBundleTask paramPrepareBundleTask, CodeMaskManager.a parama) {}
  
  public void run()
  {
    if (this.this$0.isReleased) {}
    while (!this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$PrepareBundleTask.bd.compareAndSet(false, true)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$a.aX(CodeMaskManager.a(this.this$0));
    CodeMaskManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.2
 * JD-Core Version:    0.7.0.1
 */