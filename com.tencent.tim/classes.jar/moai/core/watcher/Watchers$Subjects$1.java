package moai.core.watcher;

import rx.subjects.PublishSubject;
import rx.subjects.Subject;

 enum Watchers$Subjects$1
{
  Watchers$Subjects$1()
  {
    super(str, i, null);
  }
  
  Subject<Watchers.Context, Watchers.Context> create()
  {
    return PublishSubject.create();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.watcher.Watchers.Subjects.1
 * JD-Core Version:    0.7.0.1
 */