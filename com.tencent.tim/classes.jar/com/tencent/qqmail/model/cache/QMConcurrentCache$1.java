package com.tencent.qqmail.model.cache;

class QMConcurrentCache$1
  implements IQuery<E>
{
  QMConcurrentCache$1(QMConcurrentCache paramQMConcurrentCache, IMapper paramIMapper) {}
  
  public boolean map(E paramE)
  {
    return this.val$mapper.map(paramE);
  }
  
  public void reduce(E paramE)
  {
    this.this$0.remove(this.this$0.getKeyByItem(paramE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMConcurrentCache.1
 * JD-Core Version:    0.7.0.1
 */