@Grab('org.apache.commons:commons-math3:3.4.1')
import org.apache.commons.math3.primes.Primes
void parallelize(int count) {
  println "begin"
  if (!Primes.isPrime(count)) {
    error "${count} was not prime"
  }
  else{
      error "its a primr"
  }
  return "done"
}