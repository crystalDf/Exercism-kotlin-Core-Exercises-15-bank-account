import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

class BankAccount {

    private var closed = false

    var balance = 0L
        get() = field.let {
            check(!closed)
            it
        }
        private set

    @Synchronized
    fun adjustBalance(amount: Long) {
        balance += amount
    }

    fun close() {
        closed = true
    }
}
