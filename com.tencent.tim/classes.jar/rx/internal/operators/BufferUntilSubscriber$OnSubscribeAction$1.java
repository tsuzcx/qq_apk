package rx.internal.operators;

import rx.functions.Action0;

class BufferUntilSubscriber$OnSubscribeAction$1
  implements Action0
{
  BufferUntilSubscriber$OnSubscribeAction$1(BufferUntilSubscriber.OnSubscribeAction paramOnSubscribeAction) {}
  
  public void call()
  {
    this.this$0.state.set(BufferUntilSubscriber.EMPTY_OBSERVER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.BufferUntilSubscriber.OnSubscribeAction.1
 * JD-Core Version:    0.7.0.1
 */