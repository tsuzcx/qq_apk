package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public abstract class TypeToken<T>
  extends TypeCapture<T>
  implements Serializable
{
  private final Type runtimeType;
  private transient TypeResolver typeResolver;
  
  protected TypeToken()
  {
    this.runtimeType = capture();
    if (!(this.runtimeType instanceof TypeVariable)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
      return;
    }
  }
  
  protected TypeToken(Class<?> paramClass)
  {
    Type localType = super.capture();
    if ((localType instanceof Class))
    {
      this.runtimeType = localType;
      return;
    }
    this.runtimeType = of(paramClass).resolveType(localType).runtimeType;
  }
  
  private TypeToken(Type paramType)
  {
    this.runtimeType = ((Type)Preconditions.checkNotNull(paramType));
  }
  
  private static Bounds any(Type[] paramArrayOfType)
  {
    return new Bounds(paramArrayOfType, true);
  }
  
  @Nullable
  private TypeToken<? super T> boundAsSuperclass(Type paramType)
  {
    TypeToken localTypeToken = of(paramType);
    paramType = localTypeToken;
    if (localTypeToken.getRawType().isInterface()) {
      paramType = null;
    }
    return paramType;
  }
  
  private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] paramArrayOfType)
  {
    ImmutableList.Builder localBuilder = ImmutableList.builder();
    int j = paramArrayOfType.length;
    int i = 0;
    while (i < j)
    {
      TypeToken localTypeToken = of(paramArrayOfType[i]);
      if (localTypeToken.getRawType().isInterface()) {
        localBuilder.add(localTypeToken);
      }
      i += 1;
    }
    return localBuilder.build();
  }
  
  private static Bounds every(Type[] paramArrayOfType)
  {
    return new Bounds(paramArrayOfType, false);
  }
  
  private TypeToken<? extends T> getArraySubtype(Class<?> paramClass)
  {
    return of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(paramClass.getComponentType()).runtimeType));
  }
  
  private TypeToken<? super T> getArraySupertype(Class<? super T> paramClass)
  {
    return of(newArrayClassOrGenericArrayType(((TypeToken)Preconditions.checkNotNull(getComponentType(), "%s isn't a super type of %s", paramClass, this)).getSupertype(paramClass.getComponentType()).runtimeType));
  }
  
  @Nullable
  private Type getOwnerTypeIfPresent()
  {
    if ((this.runtimeType instanceof ParameterizedType)) {
      return ((ParameterizedType)this.runtimeType).getOwnerType();
    }
    if ((this.runtimeType instanceof Class)) {
      return ((Class)this.runtimeType).getEnclosingClass();
    }
    return null;
  }
  
  private ImmutableSet<Class<? super T>> getRawTypes()
  {
    ImmutableSet.Builder localBuilder = ImmutableSet.builder();
    new TypeToken.4(this, localBuilder).visit(new Type[] { this.runtimeType });
    return localBuilder.build();
  }
  
  private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> paramClass, Type[] paramArrayOfType)
  {
    if (paramArrayOfType.length < 0) {
      return of(paramArrayOfType[0]).getSubtype(paramClass);
    }
    throw new IllegalArgumentException(paramClass + " isn't a subclass of " + this);
  }
  
  private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> paramClass, Type[] paramArrayOfType)
  {
    int j = paramArrayOfType.length;
    int i = 0;
    while (i < j)
    {
      TypeToken localTypeToken = of(paramArrayOfType[i]);
      if (localTypeToken.isSubtypeOf(paramClass)) {
        return localTypeToken.getSupertype(paramClass);
      }
      i += 1;
    }
    throw new IllegalArgumentException(paramClass + " isn't a super type of " + this);
  }
  
  private boolean is(Type paramType)
  {
    if (this.runtimeType.equals(paramType)) {
      return true;
    }
    if ((paramType instanceof WildcardType))
    {
      if ((every(((WildcardType)paramType).getUpperBounds()).isSupertypeOf(this.runtimeType)) && (every(((WildcardType)paramType).getLowerBounds()).isSubtypeOf(this.runtimeType))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  private boolean isOwnedBySubtypeOf(Type paramType)
  {
    Iterator localIterator = getTypes().iterator();
    while (localIterator.hasNext())
    {
      Type localType = ((TypeToken)localIterator.next()).getOwnerTypeIfPresent();
      if ((localType != null) && (of(localType).isSubtypeOf(paramType))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isSubtypeOfArrayType(GenericArrayType paramGenericArrayType)
  {
    if ((this.runtimeType instanceof Class))
    {
      Class localClass = (Class)this.runtimeType;
      if (!localClass.isArray()) {
        return false;
      }
      return of(localClass.getComponentType()).isSubtypeOf(paramGenericArrayType.getGenericComponentType());
    }
    if ((this.runtimeType instanceof GenericArrayType)) {
      return of(((GenericArrayType)this.runtimeType).getGenericComponentType()).isSubtypeOf(paramGenericArrayType.getGenericComponentType());
    }
    return false;
  }
  
  private boolean isSubtypeOfParameterizedType(ParameterizedType paramParameterizedType)
  {
    Object localObject = of(paramParameterizedType).getRawType();
    if (!someRawTypeIsSubclassOf((Class)localObject)) {}
    label63:
    do
    {
      return false;
      localObject = ((Class)localObject).getTypeParameters();
      Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
      int i = 0;
      for (;;)
      {
        if (i >= localObject.length) {
          break label63;
        }
        if (!resolveType(localObject[i]).is(arrayOfType[i])) {
          break;
        }
        i += 1;
      }
    } while ((!Modifier.isStatic(((Class)paramParameterizedType.getRawType()).getModifiers())) && (paramParameterizedType.getOwnerType() != null) && (!isOwnedBySubtypeOf(paramParameterizedType.getOwnerType())));
    return true;
  }
  
  private boolean isSupertypeOfArray(GenericArrayType paramGenericArrayType)
  {
    if ((this.runtimeType instanceof Class))
    {
      Class localClass = (Class)this.runtimeType;
      if (!localClass.isArray()) {
        return localClass.isAssignableFrom([Ljava.lang.Object.class);
      }
      return of(paramGenericArrayType.getGenericComponentType()).isSubtypeOf(localClass.getComponentType());
    }
    if ((this.runtimeType instanceof GenericArrayType)) {
      return of(paramGenericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType)this.runtimeType).getGenericComponentType());
    }
    return false;
  }
  
  private boolean isWrapper()
  {
    return Primitives.allWrapperTypes().contains(this.runtimeType);
  }
  
  private static Type newArrayClassOrGenericArrayType(Type paramType)
  {
    return Types.JavaVersion.JAVA7.newArrayType(paramType);
  }
  
  public static <T> TypeToken<T> of(Class<T> paramClass)
  {
    return new SimpleTypeToken(paramClass);
  }
  
  public static TypeToken<?> of(Type paramType)
  {
    return new SimpleTypeToken(paramType);
  }
  
  private Type[] resolveInPlace(Type[] paramArrayOfType)
  {
    int i = 0;
    while (i < paramArrayOfType.length)
    {
      paramArrayOfType[i] = resolveType(paramArrayOfType[i]).getType();
      i += 1;
    }
    return paramArrayOfType;
  }
  
  private TypeToken<?> resolveSupertype(Type paramType)
  {
    paramType = resolveType(paramType);
    paramType.typeResolver = this.typeResolver;
    return paramType;
  }
  
  private Type resolveTypeArgsForSubclass(Class<?> paramClass)
  {
    if (((this.runtimeType instanceof Class)) && ((paramClass.getTypeParameters().length == 0) || (getRawType().getTypeParameters().length != 0))) {
      return paramClass;
    }
    paramClass = toGenericType(paramClass);
    Type localType = paramClass.getSupertype(getRawType()).runtimeType;
    return new TypeResolver().where(localType, this.runtimeType).resolveType(paramClass.runtimeType);
  }
  
  private boolean someRawTypeIsSubclassOf(Class<?> paramClass)
  {
    Iterator localIterator = getRawTypes().iterator();
    while (localIterator.hasNext()) {
      if (paramClass.isAssignableFrom((Class)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  @VisibleForTesting
  static <T> TypeToken<? extends T> toGenericType(Class<T> paramClass)
  {
    if (paramClass.isArray()) {
      return of(Types.newArrayType(toGenericType(paramClass.getComponentType()).runtimeType));
    }
    TypeVariable[] arrayOfTypeVariable = paramClass.getTypeParameters();
    if ((paramClass.isMemberClass()) && (!Modifier.isStatic(paramClass.getModifiers()))) {}
    for (Type localType = toGenericType(paramClass.getEnclosingClass()).runtimeType; (arrayOfTypeVariable.length > 0) || ((localType != null) && (localType != paramClass.getEnclosingClass())); localType = null) {
      return of(Types.newParameterizedTypeWithOwner(localType, paramClass, arrayOfTypeVariable));
    }
    return of(paramClass);
  }
  
  public final Invokable<T, T> constructor(Constructor<?> paramConstructor)
  {
    if (paramConstructor.getDeclaringClass() == getRawType()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "%s not declared by %s", paramConstructor, getRawType());
      return new TypeToken.2(this, paramConstructor);
    }
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof TypeToken))
    {
      paramObject = (TypeToken)paramObject;
      return this.runtimeType.equals(paramObject.runtimeType);
    }
    return false;
  }
  
  @Nullable
  public final TypeToken<?> getComponentType()
  {
    Type localType = Types.getComponentType(this.runtimeType);
    if (localType == null) {
      return null;
    }
    return of(localType);
  }
  
  final ImmutableList<TypeToken<? super T>> getGenericInterfaces()
  {
    if ((this.runtimeType instanceof TypeVariable)) {
      return boundsAsInterfaces(((TypeVariable)this.runtimeType).getBounds());
    }
    if ((this.runtimeType instanceof WildcardType)) {
      return boundsAsInterfaces(((WildcardType)this.runtimeType).getUpperBounds());
    }
    ImmutableList.Builder localBuilder = ImmutableList.builder();
    Type[] arrayOfType = getRawType().getGenericInterfaces();
    int j = arrayOfType.length;
    int i = 0;
    while (i < j)
    {
      localBuilder.add(resolveSupertype(arrayOfType[i]));
      i += 1;
    }
    return localBuilder.build();
  }
  
  @Nullable
  final TypeToken<? super T> getGenericSuperclass()
  {
    if ((this.runtimeType instanceof TypeVariable)) {
      return boundAsSuperclass(((TypeVariable)this.runtimeType).getBounds()[0]);
    }
    if ((this.runtimeType instanceof WildcardType)) {
      return boundAsSuperclass(((WildcardType)this.runtimeType).getUpperBounds()[0]);
    }
    Type localType = getRawType().getGenericSuperclass();
    if (localType == null) {
      return null;
    }
    return resolveSupertype(localType);
  }
  
  public final Class<? super T> getRawType()
  {
    return (Class)getRawTypes().iterator().next();
  }
  
  public final TypeToken<? extends T> getSubtype(Class<?> paramClass)
  {
    if (!(this.runtimeType instanceof TypeVariable)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot get subtype of type variable <%s>", this);
      if (!(this.runtimeType instanceof WildcardType)) {
        break;
      }
      return getSubtypeFromLowerBounds(paramClass, ((WildcardType)this.runtimeType).getLowerBounds());
    }
    if (isArray()) {
      return getArraySubtype(paramClass);
    }
    Preconditions.checkArgument(getRawType().isAssignableFrom(paramClass), "%s isn't a subclass of %s", paramClass, this);
    return of(resolveTypeArgsForSubclass(paramClass));
  }
  
  public final TypeToken<? super T> getSupertype(Class<? super T> paramClass)
  {
    Preconditions.checkArgument(someRawTypeIsSubclassOf(paramClass), "%s is not a super class of %s", paramClass, this);
    if ((this.runtimeType instanceof TypeVariable)) {
      return getSupertypeFromUpperBounds(paramClass, ((TypeVariable)this.runtimeType).getBounds());
    }
    if ((this.runtimeType instanceof WildcardType)) {
      return getSupertypeFromUpperBounds(paramClass, ((WildcardType)this.runtimeType).getUpperBounds());
    }
    if (paramClass.isArray()) {
      return getArraySupertype(paramClass);
    }
    return resolveSupertype(toGenericType(paramClass).runtimeType);
  }
  
  public final Type getType()
  {
    return this.runtimeType;
  }
  
  public final TypeToken<T>.TypeSet getTypes()
  {
    return new TypeSet();
  }
  
  public int hashCode()
  {
    return this.runtimeType.hashCode();
  }
  
  public final boolean isArray()
  {
    return getComponentType() != null;
  }
  
  public final boolean isPrimitive()
  {
    return ((this.runtimeType instanceof Class)) && (((Class)this.runtimeType).isPrimitive());
  }
  
  public final boolean isSubtypeOf(TypeToken<?> paramTypeToken)
  {
    return isSubtypeOf(paramTypeToken.getType());
  }
  
  public final boolean isSubtypeOf(Type paramType)
  {
    Preconditions.checkNotNull(paramType);
    if ((paramType instanceof WildcardType)) {
      return any(((WildcardType)paramType).getLowerBounds()).isSupertypeOf(this.runtimeType);
    }
    if ((this.runtimeType instanceof WildcardType)) {
      return any(((WildcardType)this.runtimeType).getUpperBounds()).isSubtypeOf(paramType);
    }
    if ((this.runtimeType instanceof TypeVariable)) {
      return (this.runtimeType.equals(paramType)) || (any(((TypeVariable)this.runtimeType).getBounds()).isSubtypeOf(paramType));
    }
    if ((this.runtimeType instanceof GenericArrayType)) {
      return of(paramType).isSupertypeOfArray((GenericArrayType)this.runtimeType);
    }
    if ((paramType instanceof Class)) {
      return someRawTypeIsSubclassOf((Class)paramType);
    }
    if ((paramType instanceof ParameterizedType)) {
      return isSubtypeOfParameterizedType((ParameterizedType)paramType);
    }
    if ((paramType instanceof GenericArrayType)) {
      return isSubtypeOfArrayType((GenericArrayType)paramType);
    }
    return false;
  }
  
  public final boolean isSupertypeOf(TypeToken<?> paramTypeToken)
  {
    return paramTypeToken.isSubtypeOf(getType());
  }
  
  public final boolean isSupertypeOf(Type paramType)
  {
    return of(paramType).isSubtypeOf(getType());
  }
  
  public final Invokable<T, Object> method(Method paramMethod)
  {
    Preconditions.checkArgument(someRawTypeIsSubclassOf(paramMethod.getDeclaringClass()), "%s not declared by %s", paramMethod, this);
    return new TypeToken.1(this, paramMethod);
  }
  
  @CanIgnoreReturnValue
  final TypeToken<T> rejectTypeVariables()
  {
    new TypeToken.3(this).visit(new Type[] { this.runtimeType });
    return this;
  }
  
  public final TypeToken<?> resolveType(Type paramType)
  {
    Preconditions.checkNotNull(paramType);
    TypeResolver localTypeResolver2 = this.typeResolver;
    TypeResolver localTypeResolver1 = localTypeResolver2;
    if (localTypeResolver2 == null)
    {
      localTypeResolver1 = TypeResolver.accordingTo(this.runtimeType);
      this.typeResolver = localTypeResolver1;
    }
    return of(localTypeResolver1.resolveType(paramType));
  }
  
  public String toString()
  {
    return Types.toString(this.runtimeType);
  }
  
  public final TypeToken<T> unwrap()
  {
    TypeToken localTypeToken = this;
    if (isWrapper()) {
      localTypeToken = of(Primitives.unwrap((Class)this.runtimeType));
    }
    return localTypeToken;
  }
  
  public final <X> TypeToken<T> where(TypeParameter<X> paramTypeParameter, TypeToken<X> paramTypeToken)
  {
    return new SimpleTypeToken(new TypeResolver().where(ImmutableMap.of(new TypeResolver.TypeVariableKey(paramTypeParameter.typeVariable), paramTypeToken.runtimeType)).resolveType(this.runtimeType));
  }
  
  public final <X> TypeToken<T> where(TypeParameter<X> paramTypeParameter, Class<X> paramClass)
  {
    return where(paramTypeParameter, of(paramClass));
  }
  
  public final TypeToken<T> wrap()
  {
    TypeToken localTypeToken = this;
    if (isPrimitive()) {
      localTypeToken = of(Primitives.wrap((Class)this.runtimeType));
    }
    return localTypeToken;
  }
  
  protected Object writeReplace()
  {
    return of(new TypeResolver().resolveType(this.runtimeType));
  }
  
  static class Bounds
  {
    private final Type[] bounds;
    private final boolean target;
    
    Bounds(Type[] paramArrayOfType, boolean paramBoolean)
    {
      this.bounds = paramArrayOfType;
      this.target = paramBoolean;
    }
    
    boolean isSubtypeOf(Type paramType)
    {
      boolean bool = false;
      Type[] arrayOfType = this.bounds;
      int j = arrayOfType.length;
      int i = 0;
      if (i < j) {
        if (TypeToken.of(arrayOfType[i]).isSubtypeOf(paramType) == this.target) {
          bool = this.target;
        }
      }
      while (this.target)
      {
        return bool;
        i += 1;
        break;
      }
      return true;
    }
    
    boolean isSupertypeOf(Type paramType)
    {
      boolean bool = false;
      paramType = TypeToken.of(paramType);
      Type[] arrayOfType = this.bounds;
      int j = arrayOfType.length;
      int i = 0;
      if (i < j) {
        if (paramType.isSubtypeOf(arrayOfType[i]) == this.target) {
          bool = this.target;
        }
      }
      while (this.target)
      {
        return bool;
        i += 1;
        break;
      }
      return true;
    }
  }
  
  final class ClassSet
    extends TypeToken<T>.TypeSet
  {
    private static final long serialVersionUID = 0L;
    private transient ImmutableSet<TypeToken<? super T>> classes;
    
    private ClassSet()
    {
      super();
    }
    
    private Object readResolve()
    {
      return TypeToken.this.getTypes().classes();
    }
    
    public TypeToken<T>.TypeSet classes()
    {
      return this;
    }
    
    public Set<TypeToken<? super T>> delegate()
    {
      ImmutableSet localImmutableSet2 = this.classes;
      ImmutableSet localImmutableSet1 = localImmutableSet2;
      if (localImmutableSet2 == null)
      {
        localImmutableSet1 = FluentIterable.from(TypeToken.TypeCollector.FOR_GENERIC_TYPE.classesOnly().collectTypes(TypeToken.this)).filter(TypeToken.TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
        this.classes = localImmutableSet1;
      }
      return localImmutableSet1;
    }
    
    public TypeToken<T>.TypeSet interfaces()
    {
      throw new UnsupportedOperationException("classes().interfaces() not supported.");
    }
    
    public Set<Class<? super T>> rawTypes()
    {
      return ImmutableSet.copyOf(TypeToken.TypeCollector.FOR_RAW_TYPE.classesOnly().collectTypes(TypeToken.this.getRawTypes()));
    }
  }
  
  final class InterfaceSet
    extends TypeToken<T>.TypeSet
  {
    private static final long serialVersionUID = 0L;
    private final transient TypeToken<T>.TypeSet allTypes;
    private transient ImmutableSet<TypeToken<? super T>> interfaces;
    
    InterfaceSet()
    {
      super();
      Object localObject;
      this.allTypes = localObject;
    }
    
    private Object readResolve()
    {
      return TypeToken.this.getTypes().interfaces();
    }
    
    public TypeToken<T>.TypeSet classes()
    {
      throw new UnsupportedOperationException("interfaces().classes() not supported.");
    }
    
    public Set<TypeToken<? super T>> delegate()
    {
      ImmutableSet localImmutableSet2 = this.interfaces;
      ImmutableSet localImmutableSet1 = localImmutableSet2;
      if (localImmutableSet2 == null)
      {
        localImmutableSet1 = FluentIterable.from(this.allTypes).filter(TypeToken.TypeFilter.INTERFACE_ONLY).toSet();
        this.interfaces = localImmutableSet1;
      }
      return localImmutableSet1;
    }
    
    public TypeToken<T>.TypeSet interfaces()
    {
      return this;
    }
    
    public Set<Class<? super T>> rawTypes()
    {
      return FluentIterable.from(TypeToken.TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.this.getRawTypes())).filter(new TypeToken.InterfaceSet.1(this)).toSet();
    }
  }
  
  static final class SimpleTypeToken<T>
    extends TypeToken<T>
  {
    private static final long serialVersionUID = 0L;
    
    SimpleTypeToken(Type paramType)
    {
      super(null);
    }
  }
  
  static abstract class TypeCollector<K>
  {
    static final TypeCollector<TypeToken<?>> FOR_GENERIC_TYPE = new TypeToken.TypeCollector.1();
    static final TypeCollector<Class<?>> FOR_RAW_TYPE = new TypeToken.TypeCollector.2();
    
    @CanIgnoreReturnValue
    private int collectTypes(K paramK, Map<? super K, Integer> paramMap)
    {
      Object localObject = (Integer)paramMap.get(paramK);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      if (getRawType(paramK).isInterface()) {}
      for (int i = 1;; i = 0)
      {
        localObject = getInterfaces(paramK).iterator();
        while (((Iterator)localObject).hasNext()) {
          i = Math.max(i, collectTypes(((Iterator)localObject).next(), paramMap));
        }
      }
      localObject = getSuperclass(paramK);
      int j = i;
      if (localObject != null) {
        j = Math.max(i, collectTypes(localObject, paramMap));
      }
      paramMap.put(paramK, Integer.valueOf(j + 1));
      return j + 1;
    }
    
    private static <K, V> ImmutableList<K> sortKeysByValue(Map<K, V> paramMap, Comparator<? super V> paramComparator)
    {
      return new TypeToken.TypeCollector.4(paramComparator, paramMap).immutableSortedCopy(paramMap.keySet());
    }
    
    final TypeCollector<K> classesOnly()
    {
      return new TypeToken.TypeCollector.3(this, this);
    }
    
    ImmutableList<K> collectTypes(Iterable<? extends K> paramIterable)
    {
      HashMap localHashMap = Maps.newHashMap();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        collectTypes(paramIterable.next(), localHashMap);
      }
      return sortKeysByValue(localHashMap, Ordering.natural().reverse());
    }
    
    final ImmutableList<K> collectTypes(K paramK)
    {
      return collectTypes(ImmutableList.of(paramK));
    }
    
    abstract Iterable<? extends K> getInterfaces(K paramK);
    
    abstract Class<?> getRawType(K paramK);
    
    @Nullable
    abstract K getSuperclass(K paramK);
    
    static class ForwardingTypeCollector<K>
      extends TypeToken.TypeCollector<K>
    {
      private final TypeToken.TypeCollector<K> delegate;
      
      ForwardingTypeCollector(TypeToken.TypeCollector<K> paramTypeCollector)
      {
        super();
        this.delegate = paramTypeCollector;
      }
      
      Iterable<? extends K> getInterfaces(K paramK)
      {
        return this.delegate.getInterfaces(paramK);
      }
      
      Class<?> getRawType(K paramK)
      {
        return this.delegate.getRawType(paramK);
      }
      
      K getSuperclass(K paramK)
      {
        return this.delegate.getSuperclass(paramK);
      }
    }
  }
  
  static abstract enum TypeFilter
    implements Predicate<TypeToken<?>>
  {
    IGNORE_TYPE_VARIABLE_OR_WILDCARD,  INTERFACE_ONLY;
    
    private TypeFilter() {}
  }
  
  public class TypeSet
    extends ForwardingSet<TypeToken<? super T>>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private transient ImmutableSet<TypeToken<? super T>> types;
    
    TypeSet() {}
    
    public TypeToken<T>.TypeSet classes()
    {
      return new TypeToken.ClassSet(TypeToken.this, null);
    }
    
    public Set<TypeToken<? super T>> delegate()
    {
      ImmutableSet localImmutableSet2 = this.types;
      ImmutableSet localImmutableSet1 = localImmutableSet2;
      if (localImmutableSet2 == null)
      {
        localImmutableSet1 = FluentIterable.from(TypeToken.TypeCollector.FOR_GENERIC_TYPE.collectTypes(TypeToken.this)).filter(TypeToken.TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
        this.types = localImmutableSet1;
      }
      return localImmutableSet1;
    }
    
    public TypeToken<T>.TypeSet interfaces()
    {
      return new TypeToken.InterfaceSet(TypeToken.this, this);
    }
    
    public Set<Class<? super T>> rawTypes()
    {
      return ImmutableSet.copyOf(TypeToken.TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.this.getRawTypes()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeToken
 * JD-Core Version:    0.7.0.1
 */