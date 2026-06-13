package main

import (
	"fmt"
)

func display() {
	sum := 0
	for i := 0; i < 3; i++ {
		fmt.Println(i)
		sum += i
	}
	fmt.Println(sum)
}
func add(a int, b int) int {
	fmt.Println("Adding two numbers")
	return a + b

}

func main() {
	var name string = "John"
	fmt.Println("Hello", name)
	var age int = 30
	fmt.Println("Age:", age)
	var array [3]int = [3]int{1, 2, 3}
	for(i := 0; i < len(array); i++) {
		fmt.Println("Element at index", i, "is", array[i])
	}
	
	fmt.Println("Array:", array)
	fmt.Println("value of 1:", array[1])
	fmt.Println("Hello world")
	display()
	fmt.Println(add(2, 3))
}
