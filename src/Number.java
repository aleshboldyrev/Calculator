class Number {
    private int value;
    private Alphabet alphabet;

    public Number(int value, Alphabet alphabet) {
        this.value = value;
        this.alphabet = alphabet;
    }

    public int getValue() {
        return value;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }
}