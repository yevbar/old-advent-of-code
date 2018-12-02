package main

import (
  "bufio"
  "fmt"
  "log"
  "os"
)

func readLines(path string) ([]string, error) {
  file, err := os.Open(path)
  if err != nil {
    return nil, err
  }
  defer file.Close()

  var lines []string
  scanner := bufio.NewScanner(file)
  for scanner.Scan() {
    lines = append(lines, scanner.Text())
  }
  return lines, scanner.Err()
}

func differenceBetweenStrings (string1 string, string2 string) int {
  output := len(string1)

  for i := 0; i < len(string1); i++ {
    if string1[i] == string2[i] {
      output -= 1
    }
  }

  return output
}
 
func main() {
  lines, err := readLines("input.txt")
  if err != nil {
    log.Fatalf("readLines: %s", err)
  }

  length := len(lines)
  output1 := ""
  output2 := ""

  for i := 0; i < length; i++ {
    for j := i; j < length; j++ {
      string1 := lines[i]
      string2 := lines[j]
      difference := differenceBetweenStrings(string1, string2)

      if difference == 1 {
        i = length
        j = length
        output1 = string1
        output2 = string2
      }
    }
  }

  output := ""
  length = len(output1)
  for k := 0; k < length; k++ {
    if output1[k] == output2[k] {
      output += string(output1[k])
    }
  }

  fmt.Println(output)
}
