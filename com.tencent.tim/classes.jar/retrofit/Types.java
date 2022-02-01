package retrofit;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;

final class Types
{
  private static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
  
  private static void checkNotPrimitive(Type paramType)
  {
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive())) {
      throw new IllegalArgumentException();
    }
  }
  
  private static Class<?> declaringClassOf(TypeVariable<?> paramTypeVariable)
  {
    paramTypeVariable = paramTypeVariable.getGenericDeclaration();
    if ((paramTypeVariable instanceof Class)) {
      return (Class)paramTypeVariable;
    }
    return null;
  }
  
  private static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean equals(Type paramType1, Type paramType2)
  {
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    if (paramType1 == paramType2) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              if ((paramType1 instanceof Class)) {
                return paramType1.equals(paramType2);
              }
              if (!(paramType1 instanceof ParameterizedType)) {
                break;
              }
              bool1 = bool3;
            } while (!(paramType2 instanceof ParameterizedType));
            paramType1 = (ParameterizedType)paramType1;
            paramType2 = (ParameterizedType)paramType2;
            if ((equal(paramType1.getOwnerType(), paramType2.getOwnerType())) && (paramType1.getRawType().equals(paramType2.getRawType())) && (Arrays.equals(paramType1.getActualTypeArguments(), paramType2.getActualTypeArguments()))) {}
            for (bool1 = bool2;; bool1 = false) {
              return bool1;
            }
            if (!(paramType1 instanceof GenericArrayType)) {
              break;
            }
            bool1 = bool3;
          } while (!(paramType2 instanceof GenericArrayType));
          paramType1 = (GenericArrayType)paramType1;
          paramType2 = (GenericArrayType)paramType2;
          return equals(paramType1.getGenericComponentType(), paramType2.getGenericComponentType());
          if (!(paramType1 instanceof WildcardType)) {
            break;
          }
          bool1 = bool3;
        } while (!(paramType2 instanceof WildcardType));
        paramType1 = (WildcardType)paramType1;
        paramType2 = (WildcardType)paramType2;
        if ((Arrays.equals(paramType1.getUpperBounds(), paramType2.getUpperBounds())) && (Arrays.equals(paramType1.getLowerBounds(), paramType2.getLowerBounds()))) {}
        for (bool1 = bool4;; bool1 = false) {
          return bool1;
        }
        bool1 = bool3;
      } while (!(paramType1 instanceof TypeVariable));
      bool1 = bool3;
    } while (!(paramType2 instanceof TypeVariable));
    paramType1 = (TypeVariable)paramType1;
    paramType2 = (TypeVariable)paramType2;
    if ((paramType1.getGenericDeclaration() == paramType2.getGenericDeclaration()) && (paramType1.getName().equals(paramType2.getName()))) {}
    for (boolean bool1 = bool5;; bool1 = false) {
      return bool1;
    }
  }
  
  static Type getGenericSupertype(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1) {
      return paramType;
    }
    if (paramClass2.isInterface())
    {
      paramType = paramClass1.getInterfaces();
      int i = 0;
      int j = paramType.length;
      while (i < j)
      {
        if (paramType[i] == paramClass2) {
          return paramClass1.getGenericInterfaces()[i];
        }
        if (paramClass2.isAssignableFrom(paramType[i])) {
          return getGenericSupertype(paramClass1.getGenericInterfaces()[i], paramType[i], paramClass2);
        }
        i += 1;
      }
    }
    if (!paramClass1.isInterface()) {
      while (paramClass1 != Object.class)
      {
        paramType = paramClass1.getSuperclass();
        if (paramType == paramClass2) {
          return paramClass1.getGenericSuperclass();
        }
        if (paramClass2.isAssignableFrom(paramType)) {
          return getGenericSupertype(paramClass1.getGenericSuperclass(), paramType, paramClass2);
        }
        paramClass1 = paramType;
      }
    }
    return paramClass2;
  }
  
  public static Class<?> getRawType(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getRawType();
      if (!(paramType instanceof Class)) {
        throw new IllegalArgumentException();
      }
      return (Class)paramType;
    }
    if ((paramType instanceof GenericArrayType)) {
      return Array.newInstance(getRawType(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    }
    if ((paramType instanceof TypeVariable)) {
      return Object.class;
    }
    if ((paramType instanceof WildcardType)) {
      return getRawType(((WildcardType)paramType).getUpperBounds()[0]);
    }
    if (paramType == null) {}
    for (String str = "null";; str = paramType.getClass().getName()) {
      throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
    }
  }
  
  public static Type getSupertype(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (!paramClass2.isAssignableFrom(paramClass1)) {
      throw new IllegalArgumentException();
    }
    return resolve(paramType, paramClass1, getGenericSupertype(paramType, paramClass1, paramClass2));
  }
  
  private static int hashCodeOrZero(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
  
  private static int indexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      if (paramObject.equals(paramArrayOfObject[i])) {
        return i;
      }
      i += 1;
    }
    throw new NoSuchElementException();
  }
  
  public static Type resolve(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    Object localObject1 = paramType2;
    if ((localObject1 instanceof TypeVariable))
    {
      localObject1 = (TypeVariable)localObject1;
      paramType2 = resolveTypeVariable(paramType1, paramClass, (TypeVariable)localObject1);
      if (paramType2 != localObject1) {}
    }
    label94:
    Object localObject3;
    label139:
    label304:
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                do
                {
                  return paramType2;
                  localObject1 = paramType2;
                  break;
                  if ((!(localObject1 instanceof Class)) || (!((Class)localObject1).isArray())) {
                    break label94;
                  }
                  paramType2 = (Class)localObject1;
                  localObject1 = paramType2.getComponentType();
                  paramType1 = resolve(paramType1, paramClass, (Type)localObject1);
                } while (localObject1 == paramType1);
                return new GenericArrayTypeImpl(paramType1);
                if (!(localObject1 instanceof GenericArrayType)) {
                  break label139;
                }
                paramType2 = (GenericArrayType)localObject1;
                localObject1 = paramType2.getGenericComponentType();
                paramType1 = resolve(paramType1, paramClass, (Type)localObject1);
              } while (localObject1 == paramType1);
              return new GenericArrayTypeImpl(paramType1);
              if (!(localObject1 instanceof ParameterizedType)) {
                break label304;
              }
              localObject2 = (ParameterizedType)localObject1;
              paramType2 = ((ParameterizedType)localObject2).getOwnerType();
              localObject3 = resolve(paramType1, paramClass, paramType2);
              if (localObject3 != paramType2) {}
              for (i = 1;; i = 0)
              {
                localObject1 = ((ParameterizedType)localObject2).getActualTypeArguments();
                int m = localObject1.length;
                int k = 0;
                while (k < m)
                {
                  Type localType = resolve(paramType1, paramClass, localObject1[k]);
                  paramType2 = (Type)localObject1;
                  int j = i;
                  if (localType != localObject1[k])
                  {
                    paramType2 = (Type)localObject1;
                    j = i;
                    if (i == 0)
                    {
                      paramType2 = (Type[])((Type[])localObject1).clone();
                      j = 1;
                    }
                    paramType2[k] = localType;
                  }
                  k += 1;
                  localObject1 = paramType2;
                  i = j;
                }
              }
              paramType2 = (Type)localObject2;
            } while (i == 0);
            return new ParameterizedTypeImpl((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), (Type[])localObject1);
            paramType2 = (Type)localObject1;
          } while (!(localObject1 instanceof WildcardType));
          localObject1 = (WildcardType)localObject1;
          localObject2 = ((WildcardType)localObject1).getLowerBounds();
          localObject3 = ((WildcardType)localObject1).getUpperBounds();
          if (localObject2.length != 1) {
            break label393;
          }
          paramType1 = resolve(paramType1, paramClass, localObject2[0]);
          paramType2 = (Type)localObject1;
        } while (paramType1 == localObject2[0]);
        return new WildcardTypeImpl(new Type[] { Object.class }, new Type[] { paramType1 });
        paramType2 = (Type)localObject1;
      } while (localObject3.length != 1);
      paramType1 = resolve(paramType1, paramClass, localObject3[0]);
      paramType2 = (Type)localObject1;
    } while (paramType1 == localObject3[0]);
    label393:
    paramClass = EMPTY_TYPE_ARRAY;
    return new WildcardTypeImpl(new Type[] { paramType1 }, paramClass);
  }
  
  private static Type resolveTypeVariable(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = declaringClassOf(paramTypeVariable);
    if (localClass == null) {}
    do
    {
      return paramTypeVariable;
      paramType = getGenericSupertype(paramType, paramClass, localClass);
    } while (!(paramType instanceof ParameterizedType));
    int i = indexOf(localClass.getTypeParameters(), paramTypeVariable);
    return ((ParameterizedType)paramType).getActualTypeArguments()[i];
  }
  
  public static String typeToString(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return ((Class)paramType).getName();
    }
    return paramType.toString();
  }
  
  static final class GenericArrayTypeImpl
    implements GenericArrayType
  {
    private final Type componentType;
    
    public GenericArrayTypeImpl(Type paramType)
    {
      this.componentType = paramType;
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof GenericArrayType)) && (Types.equals(this, (GenericArrayType)paramObject));
    }
    
    public Type getGenericComponentType()
    {
      return this.componentType;
    }
    
    public int hashCode()
    {
      return this.componentType.hashCode();
    }
    
    public String toString()
    {
      return Types.typeToString(this.componentType) + "[]";
    }
  }
  
  static final class ParameterizedTypeImpl
    implements ParameterizedType
  {
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;
    
    public ParameterizedTypeImpl(Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      if ((paramType2 instanceof Class))
      {
        if (paramType1 == null)
        {
          i = 1;
          if (((Class)paramType2).getEnclosingClass() != null) {
            break label55;
          }
        }
        for (;;)
        {
          if (i == j) {
            break label61;
          }
          throw new IllegalArgumentException();
          i = 0;
          break;
          label55:
          j = 0;
        }
      }
      label61:
      this.ownerType = paramType1;
      this.rawType = paramType2;
      this.typeArguments = ((Type[])paramVarArgs.clone());
      paramType1 = this.typeArguments;
      j = paramType1.length;
      int i = k;
      while (i < j)
      {
        paramType2 = paramType1[i];
        if (paramType2 == null) {
          throw new NullPointerException();
        }
        Types.checkNotPrimitive(paramType2);
        i += 1;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ParameterizedType)) && (Types.equals(this, (ParameterizedType)paramObject));
    }
    
    public Type[] getActualTypeArguments()
    {
      return (Type[])this.typeArguments.clone();
    }
    
    public Type getOwnerType()
    {
      return this.ownerType;
    }
    
    public Type getRawType()
    {
      return this.rawType;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ Types.hashCodeOrZero(this.ownerType);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder((this.typeArguments.length + 1) * 30);
      localStringBuilder.append(Types.typeToString(this.rawType));
      if (this.typeArguments.length == 0) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append("<").append(Types.typeToString(this.typeArguments[0]));
      int i = 1;
      while (i < this.typeArguments.length)
      {
        localStringBuilder.append(", ").append(Types.typeToString(this.typeArguments[i]));
        i += 1;
      }
      return ">";
    }
  }
  
  static final class WildcardTypeImpl
    implements WildcardType
  {
    private final Type lowerBound;
    private final Type upperBound;
    
    public WildcardTypeImpl(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      if (paramArrayOfType2.length > 1) {
        throw new IllegalArgumentException();
      }
      if (paramArrayOfType1.length != 1) {
        throw new IllegalArgumentException();
      }
      if (paramArrayOfType2.length == 1)
      {
        if (paramArrayOfType2[0] == null) {
          throw new NullPointerException();
        }
        Types.checkNotPrimitive(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] != Object.class) {
          throw new IllegalArgumentException();
        }
        this.lowerBound = paramArrayOfType2[0];
        this.upperBound = Object.class;
        return;
      }
      if (paramArrayOfType1[0] == null) {
        throw new NullPointerException();
      }
      Types.checkNotPrimitive(paramArrayOfType1[0]);
      this.lowerBound = null;
      this.upperBound = paramArrayOfType1[0];
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof WildcardType)) && (Types.equals(this, (WildcardType)paramObject));
    }
    
    public Type[] getLowerBounds()
    {
      if (this.lowerBound != null) {
        return new Type[] { this.lowerBound };
      }
      return Types.EMPTY_TYPE_ARRAY;
    }
    
    public Type[] getUpperBounds()
    {
      return new Type[] { this.upperBound };
    }
    
    public int hashCode()
    {
      if (this.lowerBound != null) {}
      for (int i = this.lowerBound.hashCode() + 31;; i = 1) {
        return i ^ this.upperBound.hashCode() + 31;
      }
    }
    
    public String toString()
    {
      if (this.lowerBound != null) {
        return "? super " + Types.typeToString(this.lowerBound);
      }
      if (this.upperBound == Object.class) {
        return "?";
      }
      return "? extends " + Types.typeToString(this.upperBound);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.Types
 * JD-Core Version:    0.7.0.1
 */